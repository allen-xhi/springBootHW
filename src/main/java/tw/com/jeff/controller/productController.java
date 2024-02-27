package tw.com.jeff.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.com.jeff.home.service.sceneryService;
import tw.com.jeff.model.SceneryBean;

@Controller
public class productController {
	@Autowired
	sceneryService service;
	@Autowired
	ServletContext context;
	@RequestMapping("/scenery")
	public String list(Model model) {
		List<SceneryBean> list = service.getAllProducts();
		model.addAttribute("views",list);
		model.addAttribute("title", "TO-touring");
		return "scenery";	
	}
	@RequestMapping(value = "/editorviews", method = RequestMethod.GET)
	public String getAddNewSceneryForm(Model model) {
		SceneryBean sc = new SceneryBean();
		model.addAttribute("SceneryBean",sc);
		return "editorviews";
	}
	@RequestMapping(value = "/editorviews", method = RequestMethod.POST)
	public String processAddNewSceneryForm(@ModelAttribute("SceneryBean") SceneryBean sc,HttpServletRequest request) {
		MultipartFile viewImage = sc.getviewImage();
		
		String originalFilename = viewImage.getOriginalFilename();
		sc.setFileName(originalFilename);
		sc.setScenerytype(0);
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		String rootDirectory = context.getRealPath("/");
		if (viewImage != null && !viewImage.isEmpty() ) {
			try {
				byte[] b = viewImage.getBytes();
				Blob blob = new SerialBlob(b);
				sc.setPhoto(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		service.addScenery(sc);
		try {
			File imageFolder = new File(rootDirectory, "images");
			if (!imageFolder.exists()) imageFolder.mkdirs();
			File file = new File(imageFolder, sc.getViewid() + ext);
			viewImage.transferTo(file);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
		}
		return "redirect:/editorviews";		
	}
	@RequestMapping(value = "/getphoto/{viewid}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getphoto(HttpServletResponse resp, @PathVariable Integer viewid) {
	    String filePath = "";
	    byte[] media = null;
	    HttpHeaders headers = new HttpHeaders();
	    String filename = "";
	    int len = 0;
	    SceneryBean bean = service.getViewById(viewid);
	    if (bean != null) {
	        Blob blob = bean.getPhoto();	        
	        if (blob != null) {
	        	filename = bean.getFileName();
	            try {
	                len = (int) blob.length();
	                media = blob.getBytes(1, len);
	            } catch (SQLException e) {
	                throw new RuntimeException("ProductController的getPicture()發生SQLException: " + e.getMessage());
	            }
	        } else {
	            media = toByteArray(filePath);    
	            filename = filePath;            
	        }
	    } else {
	      media = toByteArray(filePath);    
	        filename = filePath;            
	    }
	       headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	       String mimeType = context.getMimeType(filename);
	    MediaType mediaType = MediaType.valueOf(mimeType);
	    headers.setContentType(mediaType);
	    ResponseEntity<byte[]> responseEntity = 
	                new ResponseEntity<>(media, headers, HttpStatus.OK);
	    return responseEntity;
	}
	@ResponseBody
	@RequestMapping(value="/viewintro",method=RequestMethod.POST)
	public HashMap<String,String> viewintro(Model model, @RequestParam String viewname) {
		String[] viewname1 = viewname.split("_");
		String viewname2 = viewname1[0];
		SceneryBean list = service.getViewByName(viewname2);
		HashMap<String,String> viewintro = new HashMap<>();
		viewintro.put("name", list.getName());
		viewintro.put("country", list.getCountry());
		viewintro.put("address",list.getAddress());
		viewintro.put("introduction",list.getIntroduction());
		return viewintro;		
	}
	private byte[] toByteArray(String filepath) {
	      byte[] b = null;
	      String root = context.getRealPath("/");
	      root = root.substring(0,root.length()-1);
	      String fileLocation = root + filepath;
	      try {
	            File file = new File(fileLocation);
	            long size = file.length();
	            b = new byte[(int)size];
	            InputStream fis = context.getResourceAsStream(filepath);
	            fis.read(b);
	      } catch (FileNotFoundException e) {
	            e.printStackTrace();
	      } catch (IOException e) {
	            e.printStackTrace();
	      }
	      return b;
	}
	@InitBinder
	public void whiteListing(WebDataBinder binder) {
		binder.setAllowedFields("name", "address", "country", "city","needticket","price","introduction","viewImage");
	}
	//
	
}

package tw.com.jeff.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.com.jeff.home.service.sceneryService;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripdetailBean;

@Controller
public class customerPackageController {
	@Autowired
	sceneryService service;
	
	@Autowired
	ServletContext context;
	@RequestMapping("/customerpackage")
	public String customerPackage(Model model) {
		List<TripBean>list = service.getAllTripfromPackage();
		model.addAttribute("customerpackage",list);
		model.addAttribute("title", "TO-touring");
		return "customerpackage";		
	}
	@RequestMapping(value="/findTripDetails/{tripId}",method =RequestMethod.GET )
	public String findTripDetails(HttpServletResponse resp, @PathVariable Integer tripId,Model model) {
		String td = "trippackage"+ tripId;
		System.out.println(td);
		TripBean tb = service.getTripById(tripId);	
		Integer days = tb.getTripdays();
		List<TripdetailBean> list = service.selectTripDetailsByTripId(tripId);
		model.addAttribute("detaillist",list);
		model.addAttribute("title", "TO-touring");
		model.addAttribute("days",days);
		
		return "trippackage";
	}
	
	@RequestMapping(value = "/getpackagephoto/{tripId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getpackagephoto(HttpServletResponse resp, @PathVariable Integer tripId) {
	    String filePath = "";
	    byte[] media = null;
	    HttpHeaders headers = new HttpHeaders();
	    String filename = "";
	    int len = 0;
	    TripBean bean = service.getTripById(tripId);
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
}

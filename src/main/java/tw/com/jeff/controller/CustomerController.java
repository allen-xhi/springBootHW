package tw.com.jeff.controller;

import java.io.File;
import java.sql.Blob;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.com.jeff.google.model.CustomerSceneryBean;
import tw.com.jeff.google.service.CustomerService;
import tw.com.jeff.home.service.sceneryService;
import tw.com.jeff.model.SceneryBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripdetailBean;


@Controller
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	sceneryService service1;
	
	@RequestMapping(value="/CustomerSceneryfirst" ,method=RequestMethod.GET)
	public String addPackage(Model model) {
		TripBean tb = new TripBean();
		model.addAttribute("TripBean",tb);
		return "CustomerSceneryfirst";
	}
	@RequestMapping(value = "/CustomerSceneryfirst", method = RequestMethod.POST)
	public String processAddNewPackageTripForm(@ModelAttribute("TripBean") TripBean tb,HttpServletRequest request,Model model) {
		MultipartFile packageImage = tb.getPackageImage();
		String originalFilename = packageImage.getOriginalFilename();
		tb.setFileName(originalFilename);
		
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		String rootDirectory = context.getRealPath("/");
		if (packageImage != null && !packageImage.isEmpty() ) {
			try {
				byte[] b = packageImage.getBytes();
				Blob blob = new SerialBlob(b);
				tb.setPhoto(blob);
			} catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		service.addTrip(tb);
		try {
			File imageFolder = new File(rootDirectory, "images");
			if (!imageFolder.exists()) imageFolder.mkdirs();
			File file = new File(imageFolder, tb.getTripId() + ext);
			packageImage.transferTo(file);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
		}
		model.addAttribute("tripname",tb.getTripname());
		model.addAttribute("tripid",tb.getTripId());
		model.addAttribute("tripdays",tb.getTripdays());
		return "CustomerScenery";		
	}
	
	@RequestMapping(value="/customerscenery" ,method=RequestMethod.POST)
	public String AddCustomerScenery(Model model,@RequestParam Integer viewid,@RequestParam String name,
			@RequestParam String address,@RequestParam String city,@RequestParam String country,@RequestParam String introduction) {
		//System.out.println("SSSSSSS");
		SceneryBean cs = new SceneryBean();
		cs.setName(name);
		cs.setAddress(address);
		cs.setCity(city);
		cs.setCountry(country);
		cs.setIntroduction(introduction);
		cs.setScenerytype(1);
		
		service1.addScenery(cs);
		System.out.println("success!!");
		return "/CustomerScenery";

	}
	
	@RequestMapping(value="/customerdetails" ,method=RequestMethod.POST)
	public @ResponseBody String processAddTripDetails(Model model,@ModelAttribute("TripDetailBean")TripdetailBean tdb,
			@RequestParam HashMap<Integer,String> tripdetails,@RequestParam Integer tripId,HttpServletRequest req) {
		for(int i=0;i<tripdetails.size()-1;i++) {
		tdb.setWhichday(i+1);
		TripBean tb = service.getTripById(tripId);
		tdb.setTripbean(tb);
		String tripViews = (String) tripdetails.values().toArray()[i];
		String[] tripView = tripViews.split(",");
		for(int j = 0;j<tripView.length;j++) {
			String View = tripView[j];
			SceneryBean sb = service1.getViewByName(View);
			tdb.setSceneryBean(sb);
			System.out.println("333333333333");
			tdb.setOrderby(j+1);
			service.addTripDetails(tdb);
		}
		}				
		return "selectNeed/"+tripId;		
	}
}
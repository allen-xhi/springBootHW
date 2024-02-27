package tw.com.jeff.controller;
import java.io.File;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

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



import tw.com.jeff.home.service.sceneryService;
import tw.com.jeff.model.SceneryBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripdetailBean;

@Controller
public class TravelController {
	
	@Autowired
	sceneryService service;
	
	@Autowired
	ServletContext context;
	@RequestMapping(value="/editorpackagefirst" ,method=RequestMethod.GET)
	public String addPackage(Model model) {
		TripBean tb = new TripBean();
		model.addAttribute("TripBean",tb);
		return "/editorpackagefirst";
	}
	@RequestMapping(value = "/editorpackagefirst", method = RequestMethod.POST)
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
		return "editorpackage";		
	}
	@RequestMapping(value="/Filter1" ,method=RequestMethod.POST)
	public String FilterScenery(@RequestParam("title") String title, @RequestParam("days") String days, @RequestParam("country") String country, @RequestParam("city") String city,@RequestParam("id") String id, Model model) {
		List<SceneryBean> list = service.FilterCountryService(country);
		List<SceneryBean> list1 = service.FilterCityService(city);
		List<SceneryBean> list2 = service.getAllProducts();
		List<SceneryBean> list3 = service.FilterCountryCitySceneryDao(country, city);
		List<String> list4 = service.SelectCountryCitySceneryDao(country);
		List<String> selcity = service.SelectCityDao(city);
		model.addAttribute("country",country);
		model.addAttribute("city",city);
		model.addAttribute("days", days);
		model.addAttribute("day", days+"天");
		model.addAttribute("packagetitle",title);
		model.addAttribute("tripdays",days);
		model.addAttribute("tripid",id);
		
		if(list == null) {
			model.addAttribute("error", "不可輸入特殊符號!!");						
		}else {
		
		}
		if(list1 == null) {
			model.addAttribute("error", "不可輸入特殊符號!!");
		}else {
			
		}
		if(country != "" && city != "") {
			model.addAttribute("view",selcity);
			model.addAttribute("Views",list3);
		}else if(country != ""  && city == ""){
			model.addAttribute("view",list4);
			model.addAttribute("Views",list);
		}else if(country == "" && city != "") {
			model.addAttribute("view",selcity);
			model.addAttribute("Views", list1);
		}else {
			model.addAttribute("view",list4);
			model.addAttribute("Views", list2);
		}
		
		return "editorpackage";		
	}

	@RequestMapping(value="/tripdetails" ,method=RequestMethod.POST)
	public @ResponseBody String processAddTripDetails(Model model, @RequestParam HashMap<Integer,String> tripdetails,@RequestParam Integer tripId,HttpServletRequest req) {
		for(int i=0;i<tripdetails.size()-1;i++) {
			TripdetailBean tdb = new TripdetailBean();
		tdb.setWhichday(i+1);
		TripBean tb = service.getTripById(tripId);
		tdb.setTripbean(tb);
		String tripViews = (String) tripdetails.values().toArray()[i];
		String[] tripView = tripViews.split(",");
		for(int j = 0;j<tripView.length;j++) {
			String View = tripView[j];
			SceneryBean sb=service.getViewByName(View);
			tdb.setSceneryBean(sb);
			tdb.setOrderby(j+1);
			service.addTripDetails(tdb);
		}
		}		
		return "editorpackagefirst";		
	}

	
}
	
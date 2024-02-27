package tw.com.jeff.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.jeff.home.service.sceneryService;
import tw.com.jeff.model.FlightpriceBean;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripcommentBean;
import tw.com.jeff.model.UsercommentBean;
import tw.com.jeff.ticket.model.FlightOrderBean;
import tw.com.jeff.ticket.service.ticketservice;
import tw.com.jeff.together.service.NeedService;

@Controller
public class flightpriceController {
	@Autowired
	sceneryService service;
	@Autowired
	ticketservice ticketservice;
	////////////////////3/27
	@Autowired
	NeedService needservice;
	///////////////////////
	
	@RequestMapping(value="/changeflightprice" ,method=RequestMethod.GET)
	public String addflightprice(Model model) {
		FlightpriceBean ftp = new FlightpriceBean();
		/////////////////////////////////////////////////////3/26
		List<FlightpriceBean> oldprice =  service.getAllFlightprice();
		model.addAttribute("oldprice",oldprice);
		///////////////////////////////////////////////
		model.addAttribute("FlightpriceBean",ftp);		
		return "/changeflightprice";		
	}
	@RequestMapping(value="/changeflightprice" ,method=RequestMethod.POST)
	public String processAddflightprice(Model model,@ModelAttribute("FlightpriceBean") FlightpriceBean fpb,HttpServletRequest request) {
		FlightpriceBean ofpb = service.selectFlightpriceByPlace(fpb.getDeparture(), fpb.getDestination());
		if(ofpb == null) {
			service.addFlightprice(fpb);
		}else {
			service.updatePriceByPlace(ofpb.getDeparture(), ofpb.getDestination(),fpb.getAddpercent(),fpb.getAddprice());
		}
		return "redirect:/changeflightprice";		
	}
	//////
	@RequestMapping(value="/excel" ,method=RequestMethod.GET,produces="application/vnd.ms-excel")
	public String queryAlltripdetailsExcel(Model model) {
		List<FlightOrderBean> list = ticketservice.getAllorder();
		model.addAttribute("allTrip",list);		
		return "editorhomepage/excel";		
	}
	@RequestMapping("/tripnumber1")
	public String selectAllTripByNeed(Model model) {
		List<TripBean> needtrip = service.selectAllTripbyNeed();
		model.addAttribute("needtrip",needtrip);
		return "/tripnumber";		
	}
	Integer needid ;
	@RequestMapping(value="/usercomment1",method=RequestMethod.POST)
	@ResponseBody
	public String userCommenttripandpartner(Model model, @RequestParam Integer needId,HttpServletRequest req) {		
		
		needid=needId;
		return "usercomment";		
	}
	@RequestMapping(value="/usercomment",method=RequestMethod.GET)
	public String processctp(Model model) {
		List<NeedBean> nb = needservice.getNeedDetail(needid);
		TripBean tb = service.getTripById(nb.get(0).getTripBean().getTripId());
		List<MemberBean> joinmember = service.getjoinmemberbean(needid);
		MemberBean mb = service.getHost(needid);
		service.selectStarsfromuserId(1);
		model.addAttribute("joinmember",joinmember);
		model.addAttribute("Host",mb);
		model.addAttribute("trip",tb);		
		UsercommentBean UsercommentBean = new UsercommentBean();
		model.addAttribute("needID",needid);
		model.addAttribute("UsercommentBean",UsercommentBean);
		return "usercomment";
	}
	@RequestMapping(value="/usercomment",method=RequestMethod.POST)
	public String processUserCommenttripandpartner(Model model,@ModelAttribute("UsercommentBean") UsercommentBean ucb,HttpServletRequest req) {
		service.addMemberComment(ucb);	
		return "userinformation";		
	}
	@RequestMapping(value="/tripcomment",method=RequestMethod.POST)
	public @ResponseBody String processTripcomment(Model model,@RequestParam Double tripStarNum,@RequestParam Integer trip,@RequestParam String tripcoment) {
		TripcommentBean tcb = new TripcommentBean();
		tcb.setTripbean(trip);
		tcb.setStarNum(tripStarNum);
		tcb.setComment(tripcoment);
		service.addTripComment(tcb);
		String tripstarnum=service.selectStarsfromtripId(trip);
		return tripstarnum;	
	}
	@RequestMapping(value="/memcomment123",method=RequestMethod.POST)
	public @ResponseBody String processmemcomment(Model model,@RequestParam Double memStarNum,@RequestParam Integer memberID,@RequestParam String memcoment) {
		UsercommentBean ucb = new UsercommentBean();
		ucb.setMemberBean(memberID);
		ucb.setStarNum(memStarNum);
		ucb.setComment(memcoment);
		service.addMemberComment(ucb);
		String memstarnum=service.selectStarsfromuserId(memberID);
		return memstarnum;		
	}
}

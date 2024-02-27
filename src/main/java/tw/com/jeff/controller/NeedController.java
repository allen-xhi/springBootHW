package tw.com.jeff.controller;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.jeff.board.service.MessageBoardService;
import tw.com.jeff.config.SendEmail;
import tw.com.jeff.model.ApplicationBean;
import tw.com.jeff.model.Boardmessage;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;
import tw.com.jeff.model.TripdetailBean;
import tw.com.jeff.register.service.MemberService;
import tw.com.jeff.together.service.NeedService;




@Controller
public class NeedController {
		@Autowired
		NeedService service;
				
		@Autowired
		ServletContext context;
		
		@Autowired
		MemberService ms;
		
		@Autowired
		MessageBoardService boardservice;
	
		//insert 需求資料
		@RequestMapping(value="/selectNeed/{tripid}",method=RequestMethod.POST)
		public String Need(@ModelAttribute("insertneed") NeedBean bb ,BindingResult result,@RequestParam Integer memberId,
				HttpServletRequest request,@PathVariable Integer tripid) {
			System.out.println(tripid);
			bb.setMemberBean(ms.queryMemberByPK(memberId));
			bb.setTripBean(service.selectTripPK(tripid));
			Integer pk = service.insertNeedService(bb);
			ApplicationBean appBean = new ApplicationBean();
			appBean.setHostAgreeOrNot(1);
			appBean.setMemberBean(ms.queryMemberByPK(memberId));
			appBean.setNeedBean(service.selectNeedBean(pk));
			service.insertJoin(appBean);
			return "redirect:/GetTogether";
		}
		//揪團畫面
	@RequestMapping("/GetTogether")
	public String GetAllTogether(Model model) {
		List<NeedBean> list = service.getNeedTrip();
		model.addAttribute("NeedTrip",list);
		Integer number = list.size();
		model.addAttribute("number",number);
		return "Together";
	}
		//篩選、條件搜尋
		@RequestMapping(value="/Filter" ,method=RequestMethod.POST)
		public String FilterTrip(@RequestParam("tripname")String tripname,@RequestParam("triptype")String triptype,
				@RequestParam("countrycity")String countrycity,@RequestParam("tripdays")Integer tripdays,
				@RequestParam("lowestprice")Integer lowestprice,@RequestParam("requiredPeople")Integer requiredPeople,
				@RequestParam("DepartureTime")String DepartureTime,Model model) {
			
			System.out.println("triptype =" + triptype);
			System.out.println(tripname+triptype+countrycity+tripdays+lowestprice);
			List<NeedBean> list = service.FilterTripService(tripname, triptype, countrycity, tripdays, lowestprice,
					requiredPeople,DepartureTime);
			model.addAttribute("formtext", tripname);
			model.addAttribute("formtext1", triptype);
			model.addAttribute("formtext2", countrycity);
			model.addAttribute("formtext3", tripdays);
			model.addAttribute("formtext4", lowestprice);
			model.addAttribute("formtext5", requiredPeople);
			model.addAttribute("formtext6", DepartureTime);

			if(list==null) {
				model.addAttribute("error", "不可輸入特殊符號!!");
				List<NeedBean> list1 = service.getNeedTrip();
				model.addAttribute("NeedTrip", list1);
				Integer number = list1.size();
				model.addAttribute("number",number);
			}else {
			model.addAttribute("NeedTrip", list);
//			System.out.println(list.get(0).getNeedId());
			Integer number = list.size();
			model.addAttribute("number",number);
			}
			return "Together";
		}
		
		@RequestMapping("/Detail/{needid}")//取得詳細資料
		public String NeedDetail(Model model , @PathVariable Integer needid ,HttpServletResponse response) {
			response.setContentType("text/html;charset=UTF-8");
			
			
			//需求資訊
			List<NeedBean> list = service.getNeedDetail(needid);
			System.out.println("tripid = "+list.get(0).getTripBean().getTripId());
			//行程資訊
			List<TripdetailBean> list1 = service.getTripDetail(list.get(0).getTripBean().getTripId());
			System.out.println("needid = " + needid);
			//參加成員
			List<ApplicationBean> list2 = service.getjoinmember(needid);
			//取得此行程 的留言板內容
			List<Boardmessage> list3 = boardservice.getBmsByNeedid(needid);
			//取得此行程報名中的人
			List<ApplicationBean> list4 = service.SelectJoinPeople(needid);
			String type = list1.get(0).getTripbean().getTriptype();
//			model.addAttribute("Need",list);
			System.out.println(list1.size());
			System.out.println("needid = "+list.get(0).getNeedId());
			model.addAttribute("NeedDetail",list);
			model.addAttribute("TripDetail", list1);
			model.addAttribute("joinmember",list2);
			model.addAttribute("BoardHistory",list3);
			model.addAttribute("Reviewjoin",list4);
			System.out.println(type);
			if(type.equals("套裝行程")) {
				System.out.println("into if function");
				return "TogetherDetail";
				
			}else {
				return "TogetherDetailcustomer";
			}
		}
		//取得景點細節  沒用到
		@RequestMapping("/ShowView/{whichday}/{tripid}")
		public String ShowView(Model model,@PathVariable Integer whichday,@PathVariable Integer tripid ) {
			
			System.out.println("whichday=" +whichday +"tripid ="+tripid);
			List<TripdetailBean> list = service.getViewDetail(whichday, tripid);
			model.addAttribute("viewdetail",list);
			
			return "TogetherDetail";
		}
		@ResponseBody  //報名揪團
		@RequestMapping(value="/join",method=RequestMethod.POST)
		public String joinTrip(Model model,@RequestParam Integer joinaccountid ,@RequestParam String masteraccountid
											,@RequestParam String tripname,@RequestParam Integer needid,
											HttpServletResponse response,HttpServletRequest request) throws IOException {
			System.out.println("參加會員id="+joinaccountid +"\n" +"主辦人email="+
											masteraccountid+"tripname="+tripname +"needid="+needid);
			NeedBean NB = service.selectNeedBean(needid);
			MemberBean MB = ms.queryMemberByPK(joinaccountid);
			ApplicationBean AB = new ApplicationBean();
			AB.setMemberBean(MB);
			AB.setNeedBean(NB);
			
			//檢查報名名單內有無此會員
			Integer join = service.JudgeJoin(joinaccountid,needid);
			//檢查此行程是否滿團
			Integer check = service.CheckNeedPeople(needid);
			if(join==null) { //報名名單沒有這個會員
				if(check==1) { // 但是此行程名額已滿
					return "Full";
				}else {  //名額沒滿 
//					//取得報名者Email
//				String joinMail = service.getJoinEmail(joinaccountid);
//					//取得版主名字
//				MemberBean bean = service.getmasterEmail(masteraccountid);
//				// insert 報名資訊
//				System.out.println("Controller" + bean.getEmail()+bean.getMemberName());
//				SendEmail sendemail = new SendEmail();
//				sendemail.Sendemail(masteraccountid, joinMail,tripname,bean.getMemberName());
				Integer insert = service.insertJoin(AB);{
					
				}
				System.out.println("applicationId = "+insert);
				return "Success!";
				}
			}else {  //報名名單已經有這個會員
				return "Fail";
			}
			
		}
		@RequestMapping(value="/updateNeed/{needid}")
		public String departureUpdateNeed(@PathVariable Integer needid) {
			service.departureUpdateNeed(needid);
			System.out.println("update success");
			return "planeticketsearch";
		}
		@ResponseBody  //發送Email給版主
		@RequestMapping(value="/SendEmail",method=RequestMethod.POST)
		public String SendMail(Model model,@RequestParam Integer joinaccountid ,@RequestParam String masteraccountid
				,@RequestParam String tripname,@RequestParam Integer needid) {
			//取得報名者Email
			String joinMail = service.getJoinEmail(joinaccountid);
				//取得版主名字
			MemberBean bean = service.getmasterEmail(masteraccountid);
			// insert 報名資訊
			System.out.println("Controller" + bean.getEmail()+bean.getMemberName());
			SendEmail sendemail = new SendEmail();
			sendemail.Sendemail(masteraccountid, joinMail,tripname,bean.getMemberName(),needid);
			return "1";
		}
		@ResponseBody 
		@RequestMapping(value="/MasterRefuse",method=RequestMethod.POST)
		public String MasterRefuse(Model model,@RequestParam Integer appid) {
			 service.MasterRefuse(appid);
			
			return "Delete";
		}
		@ResponseBody
		@RequestMapping(value="/MasterAgree",method=RequestMethod.POST)
		public String MasterAgree(Model model,@RequestParam Integer appid) {
			service.MasterAgree(appid);
			
			return "Success";
		}
}

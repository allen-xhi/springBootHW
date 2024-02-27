package tw.com.jeff.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import tw.com.jeff.model.ApplicationBean;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;
import tw.com.jeff.register.service.MemberService;
import tw.com.jeff.ticket.model.FlightOrderBean;
import tw.com.jeff.ticket.model.FlightOrderDetailBean;
import tw.com.jeff.ticket.service.ticketservice;
import tw.com.jeff.together.service.NeedService;

@Controller
public class UserInfoController {

	@Autowired
	NeedService needService;

	@Autowired
	MemberService memberService;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	ticketservice ticketservice;

	@RequestMapping(value = "/needLogin/showUserDetailInfo/{memberId}")
	public String showUserInfo(Model model, @PathVariable Integer memberId, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		List<ApplicationBean> finishApp = needService.getUserFinishApp(memberId);
		List<ApplicationBean> executeApp = needService.getUserApp(memberId);
		List<ApplicationBean> payApp = needService.getUserPayApp(memberId);
		map.put("finishList", finishApp);
		map.put("payList", payApp);
		map.put("executeList", executeApp);
//		if (finishApp.size() > 0) {
//			List<ApplicationBean> finishAppList = needService.getJoinApp(finishApp.get(0).getNeedBean().getNeedId());
//			map.put("finishAppList", finishAppList);
//		}
//		if (payApp.size() > 0) {
//			List<ApplicationBean> appList = needService.getJoinApp(payApp.get(0).getNeedBean().getNeedId());
//			map.put("appList", appList);
//		} else {
//			if (executeApp.size() > 0) {
//				List<ApplicationBean> appList = needService.getJoinApp(executeApp.get(0).getNeedBean().getNeedId());
//				map.put("appList", appList);
//			}
//		}
		MemberBean memberBean = memberService.queryMemberByPK(memberId);
		Integer userID = memberBean.getId();
		List<FlightOrderDetailBean> orderDetailsList = ticketservice.getFlightOrderDetailsByMemberID(memberId);
		List<FlightOrderBean> flightOrderBeanList = memberService.getflightOrderById(memberId);
//		Map<Integer,List<FlightOrderDetailBean>> orderDetailsMap = new HashMap<>();
//		for(FlightOrderBean orderBean: flightOrderBeanList) {
//			List<FlightOrderDetailBean> orderDetailsList = ticketservice.getFlightOrderDetailsByOrderID(orderBean.getFlightOrderID());
//			orderDetailsMap.put(orderBean.getFlightOrderID(), orderDetailsList);
//		}
		map.put("flightOrderBeanList", flightOrderBeanList);
		map.put("orderDetailsList", orderDetailsList);
		request.getSession().setAttribute("userMap", map);
		return "userInformation";
	}

	@RequestMapping(value = "/needLogin/showOtherDetailInfo/{otherId}")
	public String showOtherInfo(Model model, @PathVariable Integer otherId, HttpServletRequest request) {
		MemberBean otherBean = memberService.queryMemberByPK(otherId);
		Map<String, Object> map = new HashMap<>();
		List<ApplicationBean> finishList = needService.getUserFinishApp(otherId);
		List<ApplicationBean> executeList = needService.getUserApp(otherId);
		List<ApplicationBean> payList = needService.getUserPayApp(otherId);
		map.put("finishList", finishList);
		map.put("payList", payList);
		map.put("executeList", executeList);
		map.put("otherBean", otherBean);
		request.getSession().setAttribute("otherMap", map);
		model.addAttribute("otherMap", map);
		return "otherInformation";
	}

	@RequestMapping(value = "/needLogin/updateUserInformation", method = RequestMethod.POST)
	public @ResponseBody String updateUserInformation(@RequestParam String name, @RequestParam String lastName,
			@RequestParam String firstName, @RequestParam Date birth, @RequestParam String gender,
			@RequestParam String password, @RequestParam String phone, @RequestParam String introduction,
			HttpServletRequest request) {
		System.out.println("birth : " + birth);
		HttpSession session = request.getSession();
		MemberBean memberBean = (MemberBean) session.getAttribute("memberBean");
		memberBean.setBirth(birth);
		memberBean.setFirstName(firstName);
		memberBean.setLastName(lastName);
		memberBean.setGender(gender.equals("1") ? new Byte((byte) 1) : new Byte((byte) 0));
		memberBean.setMemberName(name);
		memberBean.setPhone(phone);
		memberBean.setPassword(password);
		memberBean.setIntroduction(introduction);
		memberService.updateMember(memberBean);
		return "needLogin/showUserInfo";
	}

	@RequestMapping(value = "/getApplication/{needId}", produces = "text/html;charset=utf-8")
	public @ResponseBody String getNeedApplication(@PathVariable Integer needId) {
		List<ApplicationBean> appList = needService.getJoinApp(needId);
		Gson gson = new Gson();
		String json = gson.toJson(appList, appList.getClass());
		return json;
	}

	@RequestMapping(value = "/needLogin/updateApplication", method = RequestMethod.POST)
	public @ResponseBody String updateApplication(@RequestParam Integer id, @RequestParam Integer option) {
		ApplicationBean appBean = needService.getAppByPk(id);
		appBean.setBuyTicket(option);
		needService.updateApp(appBean);
		return "success";
	}

	@RequestMapping(value = "/planeticketsearch/{needId}")
	public String needPlanet(@PathVariable Integer needId, Model model) {
		List<NeedBean> needList = needService.getNeedDetail(needId);
		NeedBean needBean = needList.get(0);
		model.addAttribute("needBean", needBean);
		return "planeticketsearch";
	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	public @ResponseBody String forgetPassword(@RequestParam String searchEmail) {
		MemberBean memberBean = memberService.queryMemberByEmail(searchEmail);
		StringBuilder sb = new StringBuilder();
		if (memberBean != null) {		// 有此帳號
			int z;
			for (int i = 0; i < 6; i++) {
				z = (int) (Math.random() * 3);

				if (z == 1) { // 放數字
					sb.append((int) ((Math.random() * 10) + 48));
				} else if (z == 2) { // 放大寫英文
					sb.append((char) (((Math.random() * 26) + 65)));
				} else {// 放小寫英文
					sb.append(((char) ((Math.random() * 26) + 97)));
				}
			}
			memberBean.setPassword(sb.toString());
			memberService.updateMember(memberBean);
			MimeMessage msg = mailSender.createMimeMessage();
//		String url = "http://localhost:8081/FinalProject/login";
			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg, "utf-8");
				helper.setTo(memberBean.getEmail());
				helper.setSubject("密碼");

				helper.setText("你的密碼為 : " + sb + "<br>請盡快更改你的密碼", true);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mailSender.send(msg);
			return "success";
		} else {
			return "error";
		}
	}
}

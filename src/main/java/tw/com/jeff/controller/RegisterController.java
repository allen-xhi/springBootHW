package tw.com.jeff.controller;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.jeff.model.MemberBean;
import tw.com.jeff.register.service.MemberService;


@Controller
public class RegisterController {
	@Autowired
	MemberService ms;
	
	@Autowired
	JavaMailSender mailSender;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String prepareRegister(Model model) {
		MemberBean mb = new MemberBean();
		model.addAttribute("memberBean", mb);
		return "register";
	}
	
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	public @ResponseBody String checkEmail(@RequestParam String email) {
		System.out.println(email);
		if(ms.isAccountIdExist(email)) {
			return "true";
		}
		return "false";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("memberBean") MemberBean mb) {
		System.out.println(mb.getEmail());
		if (ms.isAccountIdExist(mb.getEmail())) {
			System.out.println("帳號已存在");
			return "register";
		}
		mb.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		mb.setUuid(UUID.randomUUID());
		mb.setUserType("normal");
		try {
			ms.addMember(mb);
			verifyEmail(mb);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e);
			return "register";
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/thirdLoginRegister")
	public String prepareThirdLoginRegister(Model model, HttpServletRequest request) {
		MemberBean bean = new MemberBean();
		HttpSession session = request.getSession();
		model.addAttribute("bean", bean);
		model.addAttribute("thirdLoginInfo", session.getAttribute("thirdLoginInfo"));
		return "thirdLoginRegister";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/thirdLoginRegister", method = RequestMethod.POST)
	public String finishThirdLoginRegister(@ModelAttribute("bean") MemberBean bean, HttpServletRequest request) {
		System.out.println(bean.getEmail());
		bean.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		bean.setUuid(UUID.randomUUID());
		bean.setUserType("normal");
		Map<String,String> sessionMap = (Map<String, String>) request.getSession().getAttribute("thirdLoginInfo");
		String thirdLoginType = sessionMap.get("thirdLoginType");
		if (thirdLoginType.equals("google")) {
			bean.setLoginWithGoogle(bean.getEmail());
		} else if (thirdLoginType.equals("line")) {
			bean.setLoginWithLine(bean.getEmail());
		} else if (thirdLoginType.equals("fb")) {
			bean.setLoginWithFB(bean.getEmail());
		}
		try {
			ms.addMember(bean);
			verifyEmail(bean);
		} catch (Exception e) {
			System.out.println(e);
			return "error";
		}
		System.out.println("sssss");
		return "redirect:/login";
	}
	
	
	public void verifyEmail(MemberBean bean) {
		MimeMessage msg = mailSender.createMimeMessage();
		String url = "http://localhost:8081/FinalProject/verifyEmailUrl/"+bean.getId()+"/";
		try {
			MimeMessageHelper helper = new MimeMessageHelper(msg,"utf-8");
			helper.setTo(bean.getEmail());
			helper.setSubject("此為驗證信");
			
			helper.setText("<a href='"+url+bean.getUuid()+"'>點擊來驗證</a>", true);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        mailSender.send(msg);
		
	}
	
	@RequestMapping(value="/verifyEmailUrl/{id}/{uuid}")
	public String verifyEmailUuid(HttpServletRequest request,Model model,@PathVariable String uuid,@PathVariable Integer id) {
		MemberBean bean = ms.queryMemberByPK(id);
		if(uuid.equals(bean.getUuid().toString())) {
			bean.setIsVerify(true);
			ms.updateMember(bean);
		}
		return "redirect:/needLogin/showUserInfo";
	}
}

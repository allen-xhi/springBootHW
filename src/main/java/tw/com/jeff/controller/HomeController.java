package tw.com.jeff.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;



@Controller
public class HomeController {
	

	//跳轉主頁
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "TO-touring");
		return "Home1";
	}
	//組長
	@RequestMapping("/editor")
	public String editorhome(Model model) {
		model.addAttribute("title", "TO-touring");
		return "redirect:/tripnumber1";
	}
	@RequestMapping("/editorpackage")
	public String editorpackage(Model model) {
		model.addAttribute("title", "TO-touring");
		return "editorpackage";
	}
	@RequestMapping("/editorviews")
	public String editorviews(Model model) {
		model.addAttribute("title", "TO-touring");
		return "editorviews";
	}
	@RequestMapping("/editorpackagefirst")
	public String editorpackagefirst(Model model) {
		model.addAttribute("title", "TO-touring");
		return "editorpackagefirst";
	}
	//楊立為
	//登入
	@RequestMapping(value = "/needLogin/showUserInfo")
	public String showUserInfo() {
		return "userInformation";
	}
	//登出
	@RequestMapping(value = "/needLogin/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("loginStatus", "false");
//		session.setAttribute("memberBean", new MemberBean());
//		session.removeAttribute("loginStatus");
		session.removeAttribute("memberBean");
		return "redirect:/";
	}

//	@ModelAttribute(value = "loginStatus")
//	public String getLoginStatus(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		System.out.println("loginStatus");
//		return String.valueOf(session.getAttribute("loginStatus"));
//	}
//
//
//	@ModelAttribute(value = "memberBean")
//	public MemberBean getMemberBean(HttpServletRequest request) {
//		System.out.println("memberBean");
//		HttpSession session = request.getSession();
//		MemberBean bean = (MemberBean) session.getAttribute("memberBean");
//		return bean != null ? bean : new MemberBean();
//	}
	//Jeff
	//建立需求空白表單
	@RequestMapping(value="/selectNeed/{tripid}",method = RequestMethod.GET)
	public String NeedForm(Model model ,@PathVariable Integer tripid) {
		NeedBean bb = new NeedBean();
		model.addAttribute("insertneed", bb);
		System.out.println("Need空白表單");
		return "Needs";
	}
	//楊宗融
	//留言板
	//留言板頁面
	@RequestMapping("/board")
	public String chat(Model model) {
		model.addAttribute("boardtitle","景點討論區");
		return "board";
	}
	//私聊
	//跳轉
	@RequestMapping("/water")
	public String water(Model model) {
		model.addAttribute("title","Message");
		return "water";
	}

	@RequestMapping("/emily")
	public String hebe(Model model) {
		model.addAttribute("title","Message");
		return "emily";
	}

	@RequestMapping("/AnotherPrivateMsg")
	public String Test(Model model) {
		model.addAttribute("title","test");
		return "AnotherPrivateMsg";
	}

	@RequestMapping("/WebsocketTest")
	public String welcome(Model model) {
		model.addAttribute("title","Message");
		return "WebsocketTest";
	}
	@RequestMapping("/PrivateMsg")
	public String PrivateMsg(Model model) {
		return "PrivateMsg";
	}
	@RequestMapping("/mario")
	public String mario(Model model) {
		model.addAttribute("title", "TO-touring");
		return "mario";
	}
	//機票
	@RequestMapping("/planeticketsearch")
	public String planeticketsearch(Model model) {
		model.addAttribute("title", "TO-touring");
		return "planeticketsearch";
	}
}

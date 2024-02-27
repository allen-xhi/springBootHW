package tw.com.jeff.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import tw.com.jeff.board.service.MessageBoardService;
import tw.com.jeff.board.service.PrivateMessageService;
import tw.com.jeff.model.Boardmessage;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;
import tw.com.jeff.model.PrivateMessage;


@Controller
public class BoardController {
	
	
@Autowired
MessageBoardService service;
@Autowired
PrivateMessageService pmservice;
	


//選擇對應NeedId
	@RequestMapping("/queryByNeedid")
	public String queryByNeedid(Model model) {
		List<String> list = service.getAllNeedId();
		model.addAttribute("Needidlist",list);
		return "NeedId";
	}
	//以Needid搜尋留言資料
	@RequestMapping("/board/{needid}")
	public String getboardbyneedid(@PathVariable("needid") Integer needid,Model model) {
		
	List<Boardmessage> boards = service.getBmsByNeedid(needid);
	model.addAttribute("needNo", needid);
	model.addAttribute("boards", boards);
		return "board";
	}


	//Insert留言資料，回傳前端AJAX
	@ResponseBody
	@RequestMapping(value="/addboard", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String add(@RequestParam("sentence")String sentence,@RequestParam("userid")Integer id,@RequestParam("needid")Integer needId
					,HttpServletResponse response) throws ParseException {
		
		Map<String,Object> result=new HashMap<String,Object>();
		System.out.println(sentence+id+needId);
		response.setCharacterEncoding("UTF-8");
		//取得現在時間
		Date date = new Date();
		DateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
		String LgTime = sdformat.format(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
		Date da = sdf.parse(LgTime);
		
	
		/*Date time=new Date(new java.util.Date().getTime()); */
//		NeedBean Nb = new NeedBean();
//		Nb.setNeedId(needId);
//		MemberBean Mb = new MemberBean();
//		Mb.setId(id);
		NeedBean NB = service.getNeedBeanFromNeedid(needId);
		MemberBean MB = service.getMemberBeanFromMemberid(id);
		Boardmessage bms=new Boardmessage(NB,MB,sentence,da);
		service.addMessageBoard(bms);
		JSONArray jArray = new JSONArray();
		JSONObject object = new JSONObject();
		object.put("member", MB.getMemberName());
		object.put("sentence", bms.getSentence());
		object.put("time", LgTime);
		jArray.put(object);
	
		String A = jArray.toString();
		
//		result.put("jsondata", toJson(bms));

		return A;
	}
	//JSON轉檔
	public String toJson(Object object) {
	    try {
	        ObjectMapper mapper = new ObjectMapper();
	        return mapper.writeValueAsString(object);
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException(e);
	    }
	}

}

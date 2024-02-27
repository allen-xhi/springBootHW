package tw.com.jeff.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.com.jeff.board.service.PrivateMessageService;
import tw.com.jeff.model.PrivateMessage;

@Controller

public class PrivateMessageController {

	@Autowired
	PrivateMessageService pmservice;
	
	

	

	
	//私聊controller

	//新對話存進SQL
	@ResponseBody
	@RequestMapping(value="/addPrivateMsg", method=RequestMethod.GET)
	public String addPrivateMsg(@RequestParam("roomname")String chatroomname,@RequestParam("sentence")String sentence,@RequestParam("name")String accountid
			,@RequestParam("toaccountid")String toaccountid,@RequestParam("isreadornot")String readornot) throws ParseException {
		
		System.out.println("Sentence=" + sentence +"  name="+accountid+
		"roomname="+chatroomname+" toaccountid="+toaccountid+" isreadornot="+readornot+"Save Sucess!");
		
		Date date = new Date();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
		String LgTime = sdformat.format(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制
		java.util.Date da = sdf.parse(LgTime);

		boolean isreadornot=Boolean.getBoolean(readornot);

		PrivateMessage pms=new PrivateMessage(sentence,da,accountid,toaccountid,isreadornot,chatroomname);
		pmservice.addPrivateMessage(pms);

		return "";
	}


	//取得房間ID(一對一專用)
	@ResponseBody
	@RequestMapping(value="/getroom", method=RequestMethod.GET)
	public String getroom(@RequestParam("accountid") String accountid,@RequestParam("toaccountid") String toaccountid)throws ParseException{

	List<PrivateMessage> sendlist =pmservice.getSendMessage(accountid, toaccountid);
	List<PrivateMessage> getlist =pmservice.getReciveMessage(accountid, toaccountid);

	String Sroomname;
	try {
		Sroomname = sendlist.get(0).getChatroomname();
	} catch (java.lang.IndexOutOfBoundsException e) {
		Sroomname="";
		e.printStackTrace();
	}

	if(Sroomname=="") {
		Sroomname=getlist.get(0).getChatroomname();
	};
	System.out.println("得到房間控制器"+Sroomname);
	return Sroomname;
	}


	//取得原對話紀錄
	@ResponseBody
	@RequestMapping(value="/getrecord", method=RequestMethod.POST,produces="application/json;charset=utf-8")
	public String getrecord(@RequestParam("accountid") String accountid,@RequestParam("toaccountid") String toaccountid,Model model)throws ParseException{
		
		
		List<PrivateMessage> sendlist =pmservice.getSendMessage(accountid, toaccountid);
		List<PrivateMessage> getlist =pmservice.getReciveMessage(accountid, toaccountid);

		String Sroomname;
		try {
			Sroomname = sendlist.get(0).getChatroomname();
		} catch (java.lang.IndexOutOfBoundsException e) {
			Sroomname="";
			e.printStackTrace();
		}

		if(Sroomname=="") {
			Sroomname=getlist.get(0).getChatroomname();
		};
		
		List<PrivateMessage> allmessage=pmservice.getAllMessage(Sroomname);
		JSONArray jarray = new JSONArray();

		//bean轉String
		for(int i=0;i<allmessage.size();i++) {
		JSONObject object = new JSONObject();
		object.put("toaccountid",allmessage.get(i).getToAccountId());
		object.put("sentence",allmessage.get(i).getSentence());
		jarray.put(object);
		}
		String record = jarray.toString();
		System.out.println(record);
		return record;
	}

	//取得未讀訊息數量
	@ResponseBody
	@RequestMapping(value="/getunread", method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String getunread(@RequestParam("memberid") String accountid) {
	List<PrivateMessage> list=pmservice.getUnreadMessage(accountid);
	System.out.println(list.size()+"this is getunread");
	JSONArray jarray = new JSONArray();
	JSONObject object = new JSONObject();
	int ur=list.size();
	object.put("count",ur);
	jarray.put(object);
	String unread = jarray.toString();
	return unread;
	}


	//取得私聊對象&訊息數
	@ResponseBody
	@RequestMapping(value="/getNotice", method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public String getNotice(@RequestParam("memberid") String accountid) {
	//List<PrivateMessage> list=pmservice.getUnreadMessage(accountid);
	//未讀訊息欄名稱表(不重複)
	List<String> PersonalUnread=pmservice.getPersonalUnread(accountid);
	//各欄未讀訊息筆數
	List<String> getPersonalUrNum = pmservice.getPersonalUrNum(accountid);
	
	
	
	JSONArray jArry = new JSONArray();
	for(int i=0;i<PersonalUnread.size();i++) {
	JSONObject object = new JSONObject();
	object.put("UnreadName",PersonalUnread.get(i));
	object.put("counts",getPersonalUrNum.get(i));
	jArry.put(object);
	}
	String jarry = jArry.toString();
	return jarry;
	}

	//更改未讀訊息
	@ResponseBody
	@RequestMapping(value="/Readed", method=RequestMethod.POST)
	public String Readed(@RequestParam("accountid") String accountid,@RequestParam("toaccountid") String toaccountid) {
	pmservice.Updateunread(accountid, toaccountid);
	return "redirect:/AnotherPrivateMsg";
	}

//得到好友列表
//	@ResponseBody
//	@RequestMapping(value="/getFriend", method=RequestMethod.POST,produces="application/json;charset=utf-8")
//	public String FriendList(@RequestParam("memberid") String master) {
//	
////	List<String> friendroom=pmservice.getFriendrooms(master);
//	JSONArray jArry = new JSONArray();
//	
//	for(int i=0;i<friendroom.size();i++)
//	{
//	JSONObject object = new JSONObject();
//	object.put("friend",friendroom.get(i));
//	jArry.put(object);
//	}
//	String jarry = jArry.toString();
//	System.out.println("好友列表!!!!!!!!!!!!!!!!!!");
//	return jarry;
//
//}
}
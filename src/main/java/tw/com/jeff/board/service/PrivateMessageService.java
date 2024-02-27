package tw.com.jeff.board.service;

import java.util.List;

import tw.com.jeff.model.PrivateMessage;

public interface PrivateMessageService {
	void addPrivateMessage(PrivateMessage Pms);
	public List<PrivateMessage> getSendMessage(String master,String guest);
	public List<PrivateMessage> getReciveMessage(String master,String guest);
	public List<PrivateMessage> getAllMessage(String roomNo);
	public List<PrivateMessage> getUnreadMessage(String accountid);
	public List<String> getPersonalUnread(String accountid);
	public List<String> getPersonalUrNum(String accountid);
	public void Updateunread(String master,String guest);
}

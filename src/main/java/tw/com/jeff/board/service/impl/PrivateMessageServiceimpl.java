package tw.com.jeff.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.jeff.board.dao.PrivateMessageDao;
import tw.com.jeff.board.service.PrivateMessageService;
import tw.com.jeff.model.PrivateMessage;
@Service
public class PrivateMessageServiceimpl implements PrivateMessageService {

	@Autowired
	PrivateMessageDao PMdao;
	
	
	@Override
	@Transactional
	public void addPrivateMessage(PrivateMessage Pms) {
		PMdao.addPrivateMessageDao(Pms);

	}

	@Override
	@Transactional
	public List<PrivateMessage> getSendMessage(String master, String guest) {
		return PMdao.getSendMessage(master, guest);
	}

	@Override
	@Transactional
	public List<PrivateMessage> getAllMessage(String roomNo) {
		return PMdao.getAllMessage(roomNo);
	}

	@Override
	@Transactional
	public List<PrivateMessage> getUnreadMessage(String accountid) {
		// TODO Auto-generated method stub
		return PMdao.getUnreadMessage(accountid);
	}
	@Override
	@Transactional
	public List<String> getPersonalUnread(String accountid){
		return PMdao.getPersonalUnread(accountid);
		
	}

	@Override
	@Transactional
	public List<String> getPersonalUrNum(String accountid) {
		List <String> list =PMdao.getPersonalUrNum(accountid);
		System.out.println("Service finished");
		return list;
	}

	@Override
	@Transactional
	public List<PrivateMessage> getReciveMessage(String master, String guest) {
		return PMdao.getReciveMessage(master, guest);
	}

	@Override
	@Transactional
	public void Updateunread(String master, String guest) {
		PMdao.Updateunread(master, guest);
		
	}
}

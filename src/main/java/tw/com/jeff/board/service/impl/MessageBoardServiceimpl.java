package tw.com.jeff.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.jeff.board.dao.MessageBoardDao;
import tw.com.jeff.board.service.MessageBoardService;
import tw.com.jeff.model.Boardmessage;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;



@Service
public class MessageBoardServiceimpl implements MessageBoardService {

	@Autowired 
	MessageBoardDao MBdao;
	
	
	@Override
	@Transactional
	public void addMessageBoard(Boardmessage Bms) {
		
	MBdao.addMessageBoard(Bms);
	}

	@Transactional
	@Override
	public List<String> getAllNeedId() {
	
		return MBdao.getAllNeedId();
	}
	@Transactional
	@Override
	public List<Boardmessage> getBmsByNeedid(Integer needid) {
	
		return MBdao.getBmsByNeedid(needid);
	}

	@Override
	@Transactional
	public NeedBean getNeedBeanFromNeedid(Integer needid) {
		NeedBean NB = MBdao.getNeedBeanFromNeedid(needid);
		return NB;
	}

	@Override
	@Transactional
	public MemberBean getMemberBeanFromMemberid(Integer memberid) {
		MemberBean MB = MBdao.getMemberBeanFromMemberid(memberid);
		return MB;
	}
	



	
	
}

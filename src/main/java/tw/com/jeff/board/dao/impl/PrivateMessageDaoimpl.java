package tw.com.jeff.board.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.jeff.board.dao.PrivateMessageDao;
import tw.com.jeff.model.PrivateMessage;
@Repository
public class PrivateMessageDaoimpl implements PrivateMessageDao {

	@Autowired
	SessionFactory factory;
		
	
	@Override
	public void addPrivateMessageDao(PrivateMessage Pms) {
		Session session = factory.getCurrentSession();
		session.save(Pms);
	}

//收信
	@SuppressWarnings("unchecked")
	@Override
	public List<PrivateMessage> getReciveMessage(String master, String guest) {
		String hql="FROM PrivateMessage PMS WHERE PMS.accountId =:Accountid AND PMS.toAccountId=:Toaccountid";
		List<PrivateMessage> list=new ArrayList<>();
		Session session=factory.getCurrentSession();
		list=session.createQuery(hql).setParameter("Accountid", guest).setParameter("Toaccountid", master).getResultList();
		System.out.println("this is dao"+list);
		return list;
	}
//發出
	@SuppressWarnings("unchecked")
	@Override
	public List<PrivateMessage> getSendMessage(String master, String guest) {
		String hql="FROM PrivateMessage PMS WHERE PMS.accountId =:Accountid AND PMS.toAccountId=:Toaccountid";
		List<PrivateMessage> list=new ArrayList<>();
		Session session=factory.getCurrentSession();
		list=session.createQuery(hql).setParameter("Accountid", master).setParameter("Toaccountid", guest).getResultList();
		System.out.println("this is dao"+list);
		return list;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<PrivateMessage> getAllMessage(String roomNo) {
		String hql="FROM PrivateMessage PMS WHERE PMS.chatroomname=:roomNo";
		List<PrivateMessage> list=new ArrayList<>();
		Session session=factory.getCurrentSession();
		list=session.createQuery(hql).setParameter("roomNo",roomNo).getResultList();
		return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PrivateMessage> getUnreadMessage(String accountid) {
		String hql="FROM PrivateMessage PMS WHERE PMS.toAccountId=:accountid AND PMS.isreadornot=:isreadornot";
		List<PrivateMessage> list=new ArrayList<>();
		Session session=factory.getCurrentSession();
		boolean s=false;
		list=session.createQuery(hql).setParameter("accountid",accountid).setParameter("isreadornot",s).getResultList();
		return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> getPersonalUnread(String accountid) {
		String hql="SELECT DISTINCT PMS.accountId FROM PrivateMessage PMS WHERE PMS.toAccountId=:accountid AND PMS.isreadornot=:isreadornot";
		Session session=factory.getCurrentSession();
		boolean s=false;
		List<String> list=session.createQuery(hql).setParameter("accountid", accountid).setParameter("isreadornot", s).getResultList();
		return list;
	}

	
	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public List<String> getPersonalUrNum(String accountid) {
		//資料筆數
		String hql="SELECT DISTINCT PMS.accountId FROM PrivateMessage PMS WHERE PMS.toAccountId=:accountid AND PMS.isreadornot=:isreadornot";
		Session session=factory.getCurrentSession();
		List<String> getPersonalUrNum = new ArrayList<String>();
		boolean s=false;
		List<String> list=session.createQuery(hql).setParameter("accountid", accountid).setParameter("isreadornot",s).getResultList();
		//得到姓名列
		//姓名搜尋訊息數
		String hqlforMstimes="SELECT PMS.accountId FROM PrivateMessage PMS WHERE PMS.accountId=:eachId AND PMS.toAccountId=:accountid AND PMS.isreadornot=:isreadornot";
		for(int i=0;i<list.size();i++){
		List<String> allunread = session.createQuery(hqlforMstimes).setParameter("eachId", list.get(i)).setParameter("accountid", accountid).setParameter("isreadornot",s).getResultList();
		int count=0;
		for(int a=0;a<allunread.size();a++) {
		if(list.get(i).equals(allunread.get(a))){
			count++;
			}
		}
		String counts = Integer.toString(count); 
		getPersonalUrNum.add(counts);
		
		}
		return getPersonalUrNum;
	}

	@Override
	public void Updateunread(String master,String guest) {
		String hql="UPDATE PrivateMessage PMS SET PMS.isreadornot=:isreadornot WHERE PMS.accountId=:guest AND PMS.toAccountId=:master AND PMS.isreadornot=:status";
		
		Session session=factory.getCurrentSession();
		boolean t=true;
		boolean f=false;
		int n  = session.createQuery(hql).setParameter("isreadornot",t).setParameter("guest",guest).setParameter("master",master).setParameter("status",f).executeUpdate();
		
	}

	
	
	
}

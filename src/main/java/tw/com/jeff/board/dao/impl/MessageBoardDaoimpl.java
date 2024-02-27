package tw.com.jeff.board.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.jeff.board.dao.MessageBoardDao;
import tw.com.jeff.model.Boardmessage;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;


@Repository
public class MessageBoardDaoimpl implements MessageBoardDao {
@Autowired
SessionFactory factory;
	
	@Override
	public void addMessageBoard(Boardmessage Bms) {
		System.out.println("this is DAO");
		Session session = factory.getCurrentSession();
		session.merge(Bms);
		System.out.println("finisted");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllNeedId() {
		String hql="SELECT DISTINCT B.needBean.needId FROM Boardmessage B";
//		String hql = "FROM Boardmessage B";
		Session session=factory.getCurrentSession();
		List<String> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		System.out.println(list);
		return list;
	}

		@SuppressWarnings("unchecked")
		@Override 
		public List<Boardmessage> getBmsByNeedid(Integer needid) {
			String hql ="FROM Boardmessage Bms WHERE Bms.needBean.needId =:getneedid";

			List<Boardmessage> list=new ArrayList<>();
			Session session=factory.getCurrentSession();
			list = session.createQuery(hql).setParameter("getneedid", needid).getResultList();
					return list;
	}

		@Override
		public NeedBean getNeedBeanFromNeedid(Integer needid) {
			Session session = factory.getCurrentSession();
			NeedBean NB = new NeedBean();
			String hql = "FROM NeedBean WHERE needId =:needid";
			NB = (NeedBean)session.createQuery(hql).setParameter("needid", needid).getSingleResult();
			return NB;
		}

		@Override
		public MemberBean getMemberBeanFromMemberid(Integer memberid) {
			Session session = factory.getCurrentSession();
			MemberBean MB = new MemberBean();
			String hql = "FROM MemberBean WHERE id =:memberid";
			MB = (MemberBean)session.createQuery(hql).setParameter("memberid",memberid).getSingleResult();
			return MB;
		}
}

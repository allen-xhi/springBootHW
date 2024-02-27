package tw.com.jeff.register.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.jeff.model.MemberBean;
import tw.com.jeff.ticket.model.FlightOrderBean;



@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SessionFactory factory;

	public MemberDaoImpl() {

	}


	@Override
	public MemberBean queryMemberByEmail(String email) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE email=:email";
		MemberBean bean;
		try {
			bean = (MemberBean) session.createQuery(hql).setParameter("email", email).getSingleResult();
		} catch (NonUniqueResultException | NoResultException e) {
			System.out.println(e);
			return null;
		}
		return bean;
	}

	@Override
	public MemberBean queryMemberByPK(Integer pk) {
		Session session = factory.getCurrentSession();
		MemberBean bean = session.get(MemberBean.class, pk);
		return bean;
	}

	@Override
	public void addMember(MemberBean bean) {
		Session session = factory.getCurrentSession();
		session.save(bean);
	}

	@Override
	public void updateMember(MemberBean bean) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(bean);
	}

	public boolean checkThirdLogin(String email, String thirdLogin) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE email=:email and thirdLogin=:thirdLogin";
		MemberBean bean = (MemberBean) session.createQuery(hql).setParameter("email", email)
				.setParameter("thirdLogin", thirdLogin).getSingleResult();
		if (bean == null)
			return false;
		return true;
	}

	@Override
	public MemberBean queryGoogleMember(String loginWithGoogle) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE loginWithGoogle =:google";
		MemberBean bean;
		try {
			bean = (MemberBean) session.createQuery(hql).setParameter("google", loginWithGoogle).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("no single result");
			return null;
		} catch (NonUniqueResultException e) {
			System.out.println("that should not happen");
			return null;
		}
		return bean;
	}

	@Override
	public MemberBean queryLineMember(String loginWithLine) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE loginWithLine =:line";
		MemberBean bean;
		try {
			bean = (MemberBean) session.createQuery(hql).setParameter("line", loginWithLine).getSingleResult();
		}catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("no single result");
			return null;
		} catch (NonUniqueResultException e) {
			System.out.println("that should not happen");
			return null;
		}
		return bean;
	}

	@Override
	public MemberBean queryFacebookMember(String loginWithFacebook) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE loginWithFB =:fb";
		MemberBean bean;
		try {
			bean = (MemberBean) session.createQuery(hql).setParameter("fb", loginWithFacebook).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("no single result");
			return null;
		} catch (NonUniqueResultException e) {
			System.out.println("that should not happen");
			return null;
		}
		return bean;
	}

	@Override
	public MemberBean queryThirdLoginMember(String thirdEmail, String whichThird) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE " + whichThird + " =:whichThird";
		MemberBean bean;
		try {
			bean = (MemberBean) session.createQuery(hql).setParameter("whichThird", thirdEmail).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("no single result");
			return null;
		} catch (NonUniqueResultException e) {
			System.out.println("that should not happen");
			return null;
		}
		return bean;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> queryAllMember() {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean";
		List<MemberBean> list = session.createQuery(hql).getResultList();
		return list;
	}


	@Override
	public MemberBean queryMemberByPhone(String phone) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE phone=:phone";
		MemberBean bean;
		try {
			bean = (MemberBean) session.createQuery(hql).setParameter("phone", phone).getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
			System.out.println("no single result");
			return null;
		} catch (NonUniqueResultException e) {
			System.out.println("that should not happen");
			return null;
		}
		return bean;
	}


	@Override
	public MemberBean queryMemberByAllEmail(String email) {
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean WHERE email=:email or loginWithLine =:line or loginWithGoogle =:google or loginWithFB =:fb";
		MemberBean bean;
		try {
			bean = (MemberBean) session.createQuery(hql).setParameter("email", email)
														.setParameter("line", email)
														.setParameter("google", email)
														.setParameter("fb", email)
														.getSingleResult();
		} catch (NoResultException e) {
//			e.printStackTrace();
			System.out.println("no single result");
			return null;
		} catch (NonUniqueResultException e) {
			System.out.println("that should not happen");
			return null;
		}
		return bean;
	}


	@Override
	public List<FlightOrderBean> getflightOrderById(Integer userID) {
		Session session = factory.getCurrentSession();
		String hql = "FROM FlightOrderBean WHERE memberId=:id";
		@SuppressWarnings("unchecked")
		List<FlightOrderBean> list=session.createQuery(hql).setParameter("id", userID).getResultList();
		return list;
	}

}

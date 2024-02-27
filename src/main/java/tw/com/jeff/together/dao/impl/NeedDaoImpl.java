package tw.com.jeff.together.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.jeff.model.ApplicationBean;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripdetailBean;
import tw.com.jeff.together.dao.NeedDao;


@Repository
public class NeedDaoImpl implements NeedDao {
	@Autowired
	SessionFactory factory;
	
	@Override  //未完成
	public Integer insertNeedDao(NeedBean bean) {
		Session session = factory.getCurrentSession();
		Integer pk = (Integer) session.save(bean);
		System.out.println("insert success!");
		return pk;
	}

	@Override //未完成
	public void updateNeedDao(NeedBean bean) {
		Session session = factory.getCurrentSession();
//		String hql = "FROM Need WHERE AcountId = :acountId";
		session.saveOrUpdate(bean);
		System.out.println("update success!");
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NeedBean> selectNeedDao(String AccountId) {
		Session session = factory.getCurrentSession();
		List<NeedBean> list = new ArrayList<NeedBean>();
		String hql = "FROM NeedBean WHERE AcountId =:acountid";
		list = session.createQuery(hql).setParameter("acountid", AccountId).getResultList();
		
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override  //篩選器
	public List<NeedBean> FilterTripDao(String tripname,String triptype,String countrycity,Integer tripdays,Integer lowestprice,
			Integer requiredPeople,String DepartureTime) {
		System.out.println("in"+triptype);
		Session session = factory.getCurrentSession();
		System.out.println("create session");
		List<NeedBean> list = new ArrayList<NeedBean>();

		String hql = "FROM NeedBean N join fetch N.tripBean t WHERE 1 = 1"+"\n"+
					 "AND goOrNot =0";


		if(tripname!="") {
//			tripname = "%" + tripname + "%";
			hql +=  "AND t.tripname LIKE" + " '%" +tripname +"%'" +"\n";
		}
		if(countrycity!="") {
			hql +=  "AND t.countrycity LIKE" +" '%" + countrycity+"%'" +"\n";
//			hql +=  "AND t.countrycity LIKE" +" countrycity" +"\n";
		}
			
		if(tripdays!=0) {
				hql += "AND t.tripdays ="+ tripdays + "\n";
		}
		if(lowestprice!=null) {
			hql += "AND t.lowestprice <="+lowestprice;
		}
		if(requiredPeople!=null) {
			hql += "AND requiredPeople ="+requiredPeople +"\n";
		}
		if(DepartureTime!=null) {
			hql+= "AND departureTime LIKE '%" + DepartureTime + "%'\n";
		}if(triptype!="") {
			hql+= "AND t.triptype ='" + triptype + "'\n";
		}

		System.out.println("fucking Query");
		list = session.createQuery(hql).list();
		System.out.println("query list()");
		System.out.println(list);
				
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override  //取得行程資料
	public List<NeedBean> getNeedDetail(Integer needid) {
		System.out.println("into NeedDetail Dao");
		Session session = factory.getCurrentSession();
		List<NeedBean> list = new ArrayList<NeedBean>();
		String hql = "FROM NeedBean WHERE NeedId=:needid";
		list = session.createQuery(hql).setParameter("needid", needid).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override  //取得標題資料
	public List<NeedBean> getNeedTrip() {
		Session session = factory.getCurrentSession();
		List<NeedBean> list = new ArrayList<NeedBean>();
		System.out.println("getNeedTripDao");
		String hql = "FROM NeedBean WHERE goOrNot =0";
		list = session.createQuery(hql).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override  //取得行程詳細資料
	public List<TripdetailBean> getTripDetail(Integer tripid) {
		Session session = factory.getCurrentSession();
		List<TripdetailBean> list = new ArrayList<TripdetailBean>();
		String hql = "FROM TripdetailBean WHERE FK_tripid =:tripid";
		list = session.createQuery(hql).setParameter("tripid", tripid).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override  //取得景點細節  沒用到
	public List<TripdetailBean> getViewDetail(Integer whichday, Integer tripid) {
		System.out.println("into getViewDetailDao");
		Session session = factory.getCurrentSession();
		List<TripdetailBean> list = new ArrayList<TripdetailBean>();
		String hql = "FROM TripdetailBean t join fetch t.sceneryBean s  WHERE whichday =:whichday" + "\n"+
						"AND tripid =:tripid";
		System.out.println("hql");
		list = session.createQuery(hql).setParameter("whichday", whichday).setParameter("tripid",tripid).list();
		System.out.println(list);
		System.out.println("Query end");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override //取得參加會員
	public List<ApplicationBean> getjoinmember(Integer needid) {
		Session session = factory.getCurrentSession();
		System.out.println("getjoinmember"+needid);
		List<ApplicationBean> list = new ArrayList<ApplicationBean>();
		String hql = "FROM ApplicationBean A WHERE A.needBean.needId =:needid "+"\n"+
					"AND hostAgreeOrNot =1";
		list = session.createQuery(hql).setParameter("needid", needid).list();
		System.out.println(list);
//		String hql1 = "SELECT "
		return list;
	}

	@Override  //查詢版主email
	public MemberBean getmasterEmail(String masteraccountid) {
		Session session = factory.getCurrentSession();
		MemberBean bean = new MemberBean();
		String hql = "FROM MemberBean WHERE email =:masteraccountid";
		bean = (MemberBean)session.createQuery(hql).setParameter("masteraccountid", masteraccountid).getSingleResult();
		System.out.println("Dao"+bean.getEmail()+bean.getMemberName());
		return bean;
	}

	@Override //判斷該會員是否報名過
	public Integer JudgeJoin(Integer joinid,Integer needid) {
		Session session = factory.getCurrentSession();
		System.out.println("into Dao join");
		Integer join;
		String hql = "SELECT appId FROM ApplicationBean A WHERE A.memberBean.id =:joinid \n"+
					"AND A.needBean.needId =:needid";
		try{join = (Integer)session.createQuery(hql).setParameter("joinid", joinid)
							.setParameter("needid",needid)
							.getSingleResult();
		System.out.println("Dao join = "+join);
		
	}catch(NoResultException e){
		e.printStackTrace();
		System.out.println("null");
		return null;
	}
		return join;
	}

	@SuppressWarnings("unchecked")
	@Override //檢查是否滿團
	public Integer CheckNeedPeople(Integer needid) {
		Session session = factory.getCurrentSession();
		List<ApplicationBean> list = new ArrayList<ApplicationBean>();
		Integer requiredPeople;
		String hql = "SELECT requiredPeople FROM NeedBean WHERE needId =:needid";
		String hql1 = "FROM ApplicationBean A WHERE A.needBean.needId =:needid AND hostAgreeOrNot=1";
		try{requiredPeople = (Integer)session.createQuery(hql).setParameter("needid", needid).getSingleResult();
		list = session.createQuery(hql1).setParameter("needid",needid).list();
		if(requiredPeople == list.size()) {
			return 1;  //代表滿團
		}else {
			return 0;  //代表未滿團
		}
		}catch(NoResultException e) {
			return 0;  //代表未滿團
			
		}
	}

	@Override  //取得報名Email
	public String getJoinEmail(Integer joinid) {
		Session session = factory.getCurrentSession();
		String Mail ;
		String hql = "SELECT email FROM MemberBean WHERE id =:joinid";
		Mail = (String)session.createQuery(hql).setParameter("joinid", joinid).getSingleResult();
		return Mail;
	}

	@Override  //更新出團狀態為已出團
	public void departureUpdateNeed(Integer needid) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE NeedBean SET goOrNot = 1 WHERE needId =:needid";
		session.createQuery(hql).setParameter("needid", needid).executeUpdate();
	}

	@Override  //新增報名資料
	public Integer insertJoin(ApplicationBean AB) {
		Session session = factory.getCurrentSession();
		Integer insertaccountjoinid = (Integer)session.save(AB);
		return insertaccountjoinid;
	}

	@Override  //搜尋NeedBean
	public NeedBean selectNeedBean(Integer needid) {
		Session session = factory.getCurrentSession();
		NeedBean bean = new NeedBean();
		bean = session.get(NeedBean.class, needid);
		return bean;
	}

	@SuppressWarnings("unchecked")
	@Override  //取得此行程報名審核中的會員
	public List<ApplicationBean> SelectJoinPeople(Integer needid) {
		Session session = factory.getCurrentSession();
		List<ApplicationBean> list = new ArrayList<ApplicationBean>();
		String hql = "FROM ApplicationBean A WHERE A.needBean.needId =:needid"+"\n"+
					 "AND A.hostAgreeOrNot =0";
		list = session.createQuery(hql).setParameter("needid", needid).getResultList();
				
				
		return list;
	}


	@Override
	public TripBean selectTripPK(Integer tripid) {
		Session session = factory.getCurrentSession();
		TripBean bean = session.get(TripBean.class, tripid);
		return bean;
	}

	@Override //版主拒絕報名者
	public void MasterRefuse(Integer appid) {
		Session session = factory.getCurrentSession();
		ApplicationBean bean= session.get(ApplicationBean.class, appid);
		session.delete(bean);
		
	}
	@Override //版主接受報名者,
	public void MasterAgree(Integer appid) {
		Session session = factory.getCurrentSession();
		String hql = "UPDATE ApplicationBean SET hostAgreeOrNot = 1 WHERE appId =:appid";
		session.createQuery(hql).setParameter("appid", appid).executeUpdate();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationBean> getUserApp(Integer memberId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ApplicationBean WHERE memberBean.id=:memberId AND needBean.goOrNot = 0 AND hostAgreeOrNot = 1";
		List<ApplicationBean> list = session.createQuery(hql).setParameter("memberId", memberId).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationBean> getUserFinishApp(Integer memberId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ApplicationBean WHERE memberBean.id=:memberId AND needBean.goOrNot = 2 AND hostAgreeOrNot = 1";
		List<ApplicationBean> list = session.createQuery(hql).setParameter("memberId", memberId).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationBean> getUserPayApp(Integer memberId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ApplicationBean WHERE memberBean.id=:memberId AND needBean.goOrNot = 1 AND hostAgreeOrNot = 1";
		List<ApplicationBean> list = session.createQuery(hql).setParameter("memberId", memberId).getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicationBean> getJoinApp(Integer needId) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ApplicationBean WHERE needBean.needId=:needId AND hostAgreeOrNot = 1";
		List<ApplicationBean> list = session.createQuery(hql).setParameter("needId", needId).getResultList();
		return list;
	}

	@Override
	public ApplicationBean getAppByPk(Integer appId) {
		Session session = factory.getCurrentSession();
		ApplicationBean appBean = session.get(ApplicationBean.class, appId);
		return appBean;
	}

	@Override
	public void updateApp(ApplicationBean appBean) {
		Session session = factory.getCurrentSession();
		session.update(appBean);
	}
}

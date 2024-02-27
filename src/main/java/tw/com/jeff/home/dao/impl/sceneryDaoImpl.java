package tw.com.jeff.home.dao.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.jeff.home.dao.sceneryDao;
import tw.com.jeff.home.service.sceneryService;
import tw.com.jeff.model.FlightpriceBean;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.SceneryBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripcommentBean;
import tw.com.jeff.model.TripdetailBean;
import tw.com.jeff.model.UsercommentBean;
@Repository
public class sceneryDaoImpl implements sceneryDao {

	@Autowired
	SessionFactory factory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SceneryBean> getAllProducts() {
		String hql = "FROM SceneryBean WHERE scenerytype = 0";
		Session session = null;
		List<SceneryBean> list = new ArrayList<>();
		session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void addScenery(SceneryBean view) {
		Session session = factory.getCurrentSession();
		session.save(view);
	}

	@Override
	public SceneryBean getViewById(int viewid) {
		Session session = factory.getCurrentSession();
		SceneryBean sc = session.get(SceneryBean.class, viewid);
		return sc;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SceneryBean> FilterCountrySceneryDao(String country) {
		Session session = factory.getCurrentSession();
		List<SceneryBean>list = new ArrayList<SceneryBean>();
		String hql = "From SceneryBean ";
		if(country == "") {
			hql += "where country LIKE" +" country";
		}else {
			hql +=  "where country LIKE" + " '%" +country +"%'" ;
		}
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SceneryBean> FilterCitySceneryDao(String city) {
		Session session = factory.getCurrentSession();
		List<SceneryBean>list = new ArrayList<SceneryBean>();
		String hql = "From SceneryBean ";
		if(city == "") {
			hql += "where city LIKE" +" city";
		}else {
			hql +=  "where city LIKE" + " '%" +city +"%'";
		}
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SceneryBean> FilterCountryCitySceneryDao(String country, String city) {
		Session session = factory.getCurrentSession();
		List<SceneryBean>list = new ArrayList<SceneryBean>();
		String hql = "From SceneryBean " ;
		if(country == "") {
			hql += "where country LIKE" +" country";
		}else {
			hql +=  "where country LIKE" + " '%" +country +"%'" ;
		}
		if(city == "") {
			hql += " AND city LIKE" +" city";
		}else {
			hql +=  " AND city LIKE" + " '%" +city +"%'" ;
		}
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> SelectCountryCitySceneryDao(String country) {
		Session session = factory.getCurrentSession();
		List<String> list = new ArrayList<String>();
		String hql = "SELECT DISTINCT city From SceneryBean " ;
		if(country == "") {
			hql += "where country LIKE" +" country";
		}else {
			hql +=  "where country LIKE" + " '%" +country +"%'" ;
		}
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> SelectCityDao(String city) {
		Session session = factory.getCurrentSession();
		String hql = "SELECT DISTINCT city From SceneryBean ";
		if(city == "") {
			hql += "where city LIKE" +" city";
		}else {
			hql +=  "where city LIKE" + " '%" +city +"%'";
		}
		List<String> selcity =session.createQuery(hql).getResultList();
		return selcity;
	}

	@Override
	public SceneryBean getViewByName(String viewname) {
		Session session = factory.getCurrentSession();
		String hql = "From SceneryBean where name =:viewname";
		SceneryBean sc = (SceneryBean) session.createQuery(hql).setParameter("viewname", viewname).getSingleResult();
		return sc;
	}

	@Override
	public void addTrip(TripBean tb) {
		Session session = factory.getCurrentSession();
		session.save(tb);		
	}

	@Override
	public void addTripDetails(TripdetailBean tdb) {
		Session session = factory.getCurrentSession();
		session.save(tdb);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TripBean> getAllTripfromPackage() {
		String hql = "FROM TripBean where triptype = :triptype";
		Session session = null;
		List<TripBean> list = new ArrayList<>();
		session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("triptype", "套裝行程").getResultList();
		return list;
	}

	@Override
	public TripBean getTripById(int tripId) {
		Session session = factory.getCurrentSession();
		TripBean tb = session.get(TripBean.class, tripId);
		return tb;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TripdetailBean> selectTripDetailsByTripId(int tripId) {
		Session session = factory.getCurrentSession();
		String hql = "From TripdetailBean t where t.tripbean.tripId= :tripId";
		List<TripdetailBean> list = session.createQuery(hql).setParameter("tripId", tripId).getResultList();
		return list;
	}

///////////
	@Autowired
	sceneryService ss;
	@Override
	@SuppressWarnings("unused")
	public void updatePriceByPlace(String departure, String destination,Double addpercent,int addprice) {
		Session session = factory.getCurrentSession();		
		FlightpriceBean fpb = ss.selectFlightpriceByPlace(departure, destination);
		String hql = "update FlightpriceBean fpb  SET fpb.addprice= :addprice, fpb.addpercent= :addpercent where departure = :departure AND destination = :destination";
		int n = session.createQuery(hql).setParameter("departure", departure).setParameter("destination", destination).setParameter("addprice", addprice).setParameter("addpercent", addpercent).executeUpdate();
	}

	@Override
	public FlightpriceBean selectFlightpriceByPlace(String departure, String destination) {
		Session session = factory.getCurrentSession();
		String hql = "From FlightpriceBean where departure = :departure AND destination = :destination";
		
		FlightpriceBean fpb;
		try {
			fpb = (FlightpriceBean) session.createQuery(hql).setParameter("departure", departure).setParameter("destination", destination).getSingleResult();			
		
		} catch (NoResultException e) {
			return null;
		}
		return fpb;
	}

	@Override
	public void addFlightprice(FlightpriceBean flightprice) {
		Session session = factory.getCurrentSession();
		session.save(flightprice);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FlightpriceBean> getAllFlightprice() {
		Session session = factory.getCurrentSession();
		String hql = "From FlightpriceBean";
		List<FlightpriceBean> list = session.createQuery(hql).getResultList();
		System.out.println(list);
		return list;
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public List<TripBean> selectAllTripbyNeed() {
		Session session = factory.getCurrentSession();
		String hql = "select tripBean From NeedBean";
		List<TripBean> list = session.createQuery(hql).getResultList();
		System.out.println(list.get(0));
		return list;
	}

	@Override
	public void addMemberComment(UsercommentBean usercomment) {
		Session session = factory.getCurrentSession();
		session.save(usercomment);
	}

	@Override
	public void addTripComment(TripcommentBean tripcomment) {
		Session session = factory.getCurrentSession();
		session.save(tripcomment);		
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public String selectStarsfromuserId(Integer userId) {
		Session session = factory.getCurrentSession();
		String hql = "select starNum From UsercommentBean  Where memberBean= :userId";
		List<Double> list = session.createQuery(hql).setParameter("userId", userId).getResultList();
		Double amount = 0.0;
		for(int i = 0;i<list.size();i++) {
			amount += list.get(i);
		}
		Double starnum = (double) (amount/list.size()); 
		DecimalFormat df = new DecimalFormat("#.#");
		String starnum1 = df.format(starnum);
		return starnum1;
	}
////////////////////////////////////////////////////////////
@Override
public MemberBean getHost(Integer needid) {
Session session = factory.getCurrentSession();
String hql = "select nb.memberBean From NeedBean nb where needId= :needid";
MemberBean mb = (MemberBean) session.createQuery(hql).setParameter("needid", needid).getSingleResult();		
return mb;
}

@Override
@SuppressWarnings("unchecked")
public List<MemberBean> getjoinmemberbean(Integer needid) {
Session session = factory.getCurrentSession();
String hql = "SELECT A.memberBean FROM ApplicationBean A WHERE A.needBean.needId =:needid "+"\n"+
"AND hostAgreeOrNot =1";
List<MemberBean> list = session.createQuery(hql).setParameter("needid", needid).getResultList();
return list;
}

@Override
@SuppressWarnings("unchecked")
public String selectStarsfromtripId(int tripId) {
	Session session = factory.getCurrentSession();
	String hql = "select starNum From TripcommentBean  Where tripbean= :tripId";
	List<Double> list = session.createQuery(hql).setParameter("tripId", tripId).getResultList();
	Double amount = 0.0;
	for(int i = 0;i<list.size();i++) {
		amount += list.get(i);
	}
	Double starnum = (double) (amount/list.size()); 
	DecimalFormat df = new DecimalFormat("#.#");
	String starnum1 = df.format(starnum);
	return starnum1;
}


}

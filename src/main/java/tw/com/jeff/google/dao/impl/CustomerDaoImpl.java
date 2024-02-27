package tw.com.jeff.google.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tw.com.jeff.google.dao.CustomerDao;
import tw.com.jeff.google.model.CustomerSceneryBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripdetailBean;



@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	SessionFactory factory;
		
	
	@Override
	public void insertScenery(CustomerSceneryBean cs) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.save(cs);
		System.out.println("insert success!");
	}
	
	
	@Override
	public void addTrip(TripBean tb) {
		Session session = factory.getCurrentSession();
		session.save(tb);		
	}
	
	
	@Override
	public CustomerSceneryBean getViewByName(String name) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		String hql = "From CustomerSceneryBean where name =:name";
		CustomerSceneryBean sc = (CustomerSceneryBean) session.createQuery(hql).setParameter("name", name).getSingleResult();
		return sc;
	}
	
	
	@Override
	public void addTripDetails(TripdetailBean tdb) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		session.save(tdb);	
	}


	@Override
	public TripBean getTripById(Integer tripId) {
		Session session = factory.getCurrentSession();
		String hql ="From TripBean where tripId = :tripId";
		TripBean tb = (TripBean) session.createQuery(hql).setParameter("tripId", tripId).getSingleResult();
		return tb;
	}

}

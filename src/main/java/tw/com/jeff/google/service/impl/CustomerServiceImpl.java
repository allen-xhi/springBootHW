package tw.com.jeff.google.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.jeff.google.dao.CustomerDao;
import tw.com.jeff.google.model.CustomerSceneryBean;
import tw.com.jeff.google.service.CustomerService;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripdetailBean;




@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao dao;
	
	@Transactional	
	public void insertScenery(CustomerSceneryBean cs) {
		
		    dao.insertScenery(cs);
		
	}
	
	@Transactional
	@Override
	public void addTrip(TripBean tb) {
		// TODO Auto-generated method stub
		dao.addTrip(tb);	
	}

	@Transactional
	@Override
	public CustomerSceneryBean getViewByName(String name) {
		// TODO Auto-generated method stub
		return dao.getViewByName(name);
	}

	@Transactional
	@Override
	public void addTripDetails(TripdetailBean tdb) {
			 dao.addTripDetails(tdb);	
	}
	@Transactional
	@Override
	public TripBean getTripById(Integer tripId) {

		return dao.getTripById(tripId);
	}



}

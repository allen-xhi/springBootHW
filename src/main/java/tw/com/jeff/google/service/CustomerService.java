package tw.com.jeff.google.service;

import tw.com.jeff.google.model.CustomerSceneryBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripdetailBean;


public interface CustomerService {

	void insertScenery(CustomerSceneryBean cs);

	void addTrip(TripBean tb);
	
	public CustomerSceneryBean getViewByName(String name);
	
	void addTripDetails(TripdetailBean tdb);

	TripBean getTripById(Integer tripId);
}

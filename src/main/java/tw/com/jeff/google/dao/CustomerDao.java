package tw.com.jeff.google.dao;

import tw.com.jeff.google.model.CustomerSceneryBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripdetailBean;


public interface CustomerDao {
	
	public void insertScenery(CustomerSceneryBean cs);

	public void addTrip(TripBean tb);

	public CustomerSceneryBean getViewByName(String name);

	public void addTripDetails(TripdetailBean tdb);

	TripBean getTripById(Integer tripId);
}

package tw.com.jeff.home.dao;

import java.util.List;

import tw.com.jeff.model.FlightpriceBean;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.SceneryBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripcommentBean;
import tw.com.jeff.model.TripdetailBean;
import tw.com.jeff.model.UsercommentBean;

public interface sceneryDao {
	List<SceneryBean> getAllProducts();
	public SceneryBean getViewById(int viewid);
	public SceneryBean getViewByName(String viewname);
	void addScenery(SceneryBean view);
	List<SceneryBean>FilterCountrySceneryDao(String country);
	List<SceneryBean>FilterCitySceneryDao(String city);
	List<SceneryBean>FilterCountryCitySceneryDao(String country,String city);
	List<String>SelectCountryCitySceneryDao(String country);
	List<String> SelectCityDao(String city);
	void addTrip(TripBean tb);
	void addTripDetails(TripdetailBean tdb);
	List<TripBean> getAllTripfromPackage();
	public TripBean getTripById(int tripId);
	List<TripdetailBean>selectTripDetailsByTripId(int tripId);
	//
	public void updatePriceByPlace(String departure,String destination,Double addpercent,int addprice);
	public FlightpriceBean selectFlightpriceByPlace(String departure,String destination);
	void addFlightprice(FlightpriceBean flightprice);
	List<FlightpriceBean> getAllFlightprice();
	List<TripBean>selectAllTripbyNeed();
	void addMemberComment(UsercommentBean usercomment);	
	void addTripComment(TripcommentBean tripcomment);
	public String selectStarsfromuserId(Integer userId);
	/////////////////////////3/27
	MemberBean getHost(Integer needid);
	List<MemberBean> getjoinmemberbean(Integer needid);
	/////////////////////////////
	//////////////////////////////3/29
	public String selectStarsfromtripId(int tripId);
}

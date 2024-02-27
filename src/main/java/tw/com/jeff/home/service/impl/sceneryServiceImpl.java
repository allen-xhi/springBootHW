package tw.com.jeff.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.jeff.home.dao.sceneryDao;
import tw.com.jeff.home.service.sceneryService;
import tw.com.jeff.model.FlightpriceBean;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.SceneryBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripcommentBean;
import tw.com.jeff.model.TripdetailBean;
import tw.com.jeff.model.UsercommentBean;
@Service
public class sceneryServiceImpl implements sceneryService {   
	@Autowired
	sceneryDao dao;
	
	@Override
	@Transactional
	public List<SceneryBean> getAllProducts() {
		
		return dao.getAllProducts();
	}
	@Override
	@Transactional
	public void addScenery(SceneryBean view) {
		dao.addScenery(view);
	}
	@Override
	@Transactional
	public SceneryBean getViewById(int viewid) {		
		return dao.getViewById(viewid);
	}
	@Override
	@Transactional
	public List<SceneryBean> FilterCountryService(String country) {
		List<SceneryBean> list = null;
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		Integer countrynamecorrect = 0;
		if(country !="") {
			boolean countrynameboolean = country.matches(regex1);
			if(countrynameboolean) {
				countrynamecorrect = 1;
			}
		}else {
			countrynamecorrect = 1;
		}
		if(countrynamecorrect == 1) {
		list= dao.FilterCountrySceneryDao(country);
		}else {
			list = null;
		}
		return list;
	}
	@Override
	@Transactional
	public List<SceneryBean> FilterCityService(String city) {
		List<SceneryBean> list = null;
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		Integer citynamecorrect = 0;
		if(city !="") {
			boolean citynameboolean = city.matches(regex1);
			if(citynameboolean) {
				citynamecorrect = 1;
			}
		}else {
			citynamecorrect = 1;
		}
		if(citynamecorrect == 1) {
		list= dao.FilterCitySceneryDao(city);
		}else {
			list = null;
		}
		return list;
	}
	@Override
	@Transactional
	public List<SceneryBean> FilterCountryCitySceneryDao(String country, String city) {
		List<SceneryBean> list = null;
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		Integer countrynamecorrect = 0;
		Integer citynamecorrect = 0;
		if(country !="") {
			boolean countrynameboolean = country.matches(regex1);
			if(countrynameboolean) {
				countrynamecorrect = 1;
			}
		}else {
			countrynamecorrect = 1;
		}
		if(city !="") {
			boolean citynameboolean = city.matches(regex1);
			if(citynameboolean) {
				citynamecorrect = 1;
			}
		}else {
			citynamecorrect = 1;
		}
		if(citynamecorrect == 1 && countrynamecorrect == 1) {
			list= dao.FilterCountryCitySceneryDao(country, city);
			}else {
				list = null;
			}
		return list;
	}
	@Override
	@Transactional
	public List<String> SelectCountryCitySceneryDao(String country) {
		List<String> list = null;
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		Integer countrynamecorrect = 0;
		if(country !="") {
			boolean countrynameboolean = country.matches(regex1);
			if(countrynameboolean) {
				countrynamecorrect = 1;
			}
		}else {
			countrynamecorrect = 1;
		}
		if(countrynamecorrect == 1) {
		list= dao.SelectCountryCitySceneryDao(country);
		}else {
			list = null;
		}
		return list;
	}
	@Override
	@Transactional
	public List<String> SelectCityDao(String city) {
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		List<String> selcity;
		Integer citynamecorrect = 0;
		if(city !="") {
			boolean citynameboolean = city.matches(regex1);
			if(citynameboolean) {
				citynamecorrect = 1;
			}
		}else {
			citynamecorrect = 1;
		}
		if(citynamecorrect == 1) {
		selcity = dao.SelectCityDao(city);
		}else {
			selcity = null;
		}
		return selcity;
	}
	@Override
	@Transactional
	public SceneryBean getViewByName(String viewname) {		
		return dao.getViewByName(viewname);
	}
	@Override
	@Transactional
	public void addTrip(TripBean tb) {
		dao.addTrip(tb);		
	}
	@Override
	@Transactional
	public void addTripDetails(TripdetailBean tdb) {
		dao.addTripDetails(tdb);		
	}
	@Override
	@Transactional
	public List<TripBean> getAllTripfromPackage() {
		return dao.getAllTripfromPackage();
	}
	@Override
	@Transactional
	public TripBean getTripById(int tripId) {
		return dao.getTripById(tripId);
	}
	@Override
	@Transactional
	public List<TripdetailBean> selectTripDetailsByTripId(int tripId) {
		return dao.selectTripDetailsByTripId(tripId);
	}
	
	////////////////////////
	@Override
	@Transactional
	public void updatePriceByPlace(String departure, String destination,Double addpercent,int addprice) {
		dao.updatePriceByPlace(departure, destination,addpercent,addprice);
	}
	@Override
	@Transactional
	public FlightpriceBean selectFlightpriceByPlace(String departure, String destination) {
		return dao.selectFlightpriceByPlace(departure, destination);
	}
	@Override
	@Transactional
	public void addFlightprice(FlightpriceBean flightprice) {
		dao.addFlightprice(flightprice);
	}
	@Override
	@Transactional
	public List<FlightpriceBean> getAllFlightprice() {
		return dao.getAllFlightprice();
	}
	@Override
	@Transactional
	public List<TripBean> selectAllTripbyNeed() {
		return dao.selectAllTripbyNeed();
	}
	@Override
	@Transactional
	public void addMemberComment(UsercommentBean usercomment) {
	dao.addMemberComment(usercomment);	
	}
	@Override
	@Transactional
	public void addTripComment(TripcommentBean tripcomment) {
		dao.addTripComment(tripcomment);
	}
	@Override
	@Transactional
	public String selectStarsfromuserId(Integer userId) {
		return dao.selectStarsfromuserId(userId);
	}
//////////////////////////////////
@Override
@Transactional
public MemberBean getHost(Integer needid) {
return dao.getHost(needid);
}
@Override
@Transactional
public List<MemberBean> getjoinmemberbean(Integer needid) {
return dao.getjoinmemberbean(needid);
}
@Override
@Transactional
public String selectStarsfromtripId(int tripId) {
	return dao.selectStarsfromtripId(tripId);
}
}

package tw.com.jeff.together.service;

import java.util.List;

import tw.com.jeff.model.ApplicationBean;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripdetailBean;

public interface NeedService {
	Integer insertNeedService(NeedBean bb);

	List<NeedBean> FilterTripService(String tripname,String triptype,String countrycity,Integer tripdays,Integer lowestprice,
									Integer requiredPeople,String DepartureTime);
	List<NeedBean> getNeedDetail(Integer needid);
	List<TripdetailBean> getTripDetail(Integer tripid);
	List<NeedBean> getNeedTrip();
	List<TripdetailBean> getViewDetail(Integer whichday,Integer tripid);
	List<ApplicationBean> getjoinmember(Integer needid);
	NeedBean selectNeedBean(Integer needid);
	MemberBean getmasterEmail(String masteraccountid);
	Integer JudgeJoin(Integer joinid,Integer needid);
	Integer CheckNeedPeople(Integer needid);
	String getJoinEmail(Integer joinid);
	void departureUpdateNeed(Integer needid);
	Integer insertJoin(ApplicationBean AB);
	List<ApplicationBean> SelectJoinPeople(Integer needid);

	TripBean selectTripPK(Integer tripid);
	void MasterRefuse(Integer appid);
	void MasterAgree(Integer appid);
	List<ApplicationBean> getUserApp(Integer memberId);
	List<ApplicationBean> getUserPayApp(Integer memberId);
	List<ApplicationBean> getUserFinishApp(Integer memberId);
	List<ApplicationBean> getJoinApp(Integer needId);
	ApplicationBean getAppByPk(Integer appId);
	void updateApp(ApplicationBean appBean);
	
	
	
	
	
	
	
	
}
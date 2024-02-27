package tw.com.jeff.together.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.jeff.model.ApplicationBean;
import tw.com.jeff.model.MemberBean;
import tw.com.jeff.model.NeedBean;
import tw.com.jeff.model.TripBean;
import tw.com.jeff.model.TripdetailBean;
import tw.com.jeff.together.dao.NeedDao;
import tw.com.jeff.together.service.NeedService;

@Service
public class NeedServiceImpl implements NeedService {
	
	@Autowired
	NeedDao dao;
	
	@Transactional
	@Override
	public Integer insertNeedService(NeedBean bb) {
		return dao.insertNeedDao(bb);
		
	}
	@Override
	@Transactional
	public List<NeedBean> FilterTripService(String tripname,String triptype,String countrycity,Integer tripdays,Integer lowestprice,
			Integer requiredPeople,String DepartureTime) {
		List<NeedBean> list = null;
		String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
		String regex2 =  "^[0-9]+$";
		String lowestpriceString = String.valueOf(lowestprice);
		String requiredPeopleString = String.valueOf(requiredPeople);
		Integer tripnamecorrect = 0;
		Integer countrycitycorrect = 0;
		Integer lowestpricecorrect = 0;
		Integer requiredPeoplecorrect = 0;
		if(tripname!="") {
			boolean tripnameboolean = tripname.matches(regex1);
			if(tripnameboolean) {
				tripnamecorrect = 1;
				System.out.println("tripnamecorrect set = " + tripnamecorrect );
			}
		}else {
			tripnamecorrect = 1;
		}
		if(countrycity!="") {
			boolean countrycityboolean = countrycity.matches(regex1);
			if(countrycityboolean) {
				countrycitycorrect = 1;
				System.out.println("countrycitycorrect set = " + countrycitycorrect );
			}
		}else {
			countrycitycorrect = 1;
		}
		if(lowestprice!=null) {
		boolean lowestpriceboolean = lowestpriceString.matches(regex2);
			if(lowestpriceboolean) {
				lowestpricecorrect = 1;
				System.out.println("lowestpricecorrect set = " + lowestpricecorrect );
			}
		}else {
			lowestpricecorrect = 1;
			System.out.println(lowestpricecorrect+"test");
		}
		if(requiredPeople!=null) {
			boolean requiredPeopleboolean = requiredPeopleString.matches(regex2);
			if(requiredPeopleboolean) {
				requiredPeoplecorrect = 1;
			}
		}else {
			requiredPeoplecorrect = 1;
		}
		if(tripnamecorrect==1 && countrycitycorrect==1 && lowestpricecorrect==1 && requiredPeoplecorrect==1) {
			list = dao.FilterTripDao(tripname, triptype, countrycity, tripdays, lowestprice,
					requiredPeople,DepartureTime);
			System.out.println("blablabla");

		}else {
			list = null;
			System.out.println("Service list = null");
		}
		
			System.out.println("Service NOT NULL");
		
			return list;

	}

	@Override  //取得需求詳細資料
	@Transactional
	public List<NeedBean> getNeedDetail(Integer needid) {
		System.out.println("into NeedDetail Service");
		List<NeedBean> list = dao.getNeedDetail(needid);
		return list;
	}
	@Override
	@Transactional  //取的需求詳細資料
	public List<NeedBean> getNeedTrip() {
		System.out.println("getNeedTripService");
		List<NeedBean> list = dao.getNeedTrip();
		
		
		return list;
	}
	@Override
	@Transactional  //取得行程詳細資料
	public List<TripdetailBean> getTripDetail(Integer tripid) {
	List<TripdetailBean> list = dao.getTripDetail(tripid);
		return list;
	}
	@Override
	@Transactional  //取得景點細節  沒用到
	public List<TripdetailBean> getViewDetail(Integer whichday, Integer tripid) {
		System.out.println("into getViewDetail Service");
		List<TripdetailBean> list = dao.getViewDetail(whichday, tripid);
		System.out.println("Dao success");
		return list;
	}
	@Override
	@Transactional  //取得參加會員
	public List<ApplicationBean> getjoinmember(Integer needid) {
		List<ApplicationBean> list = dao.getjoinmember(needid);
		return list;
	}
	@Override
	@Transactional  //查詢版主Email
	public MemberBean getmasterEmail(String masteraccountid) {
		
		MemberBean bean = dao.getmasterEmail(masteraccountid);
		System.out.println("Service" + bean.getEmail() +bean.getMemberName());
		return bean;
	}
	@Override
	@Transactional  //判斷該會員是否報名過
	public Integer JudgeJoin(Integer joinid,Integer needid) {
		Integer join = dao.JudgeJoin(joinid,needid);
		System.out.println("Service join = " + join);
		return join;
	}
	@Override
	@Transactional  //檢查是否滿團
	public Integer CheckNeedPeople(Integer needid) {
		Integer check = dao.CheckNeedPeople(needid);
		return check;
	}
	@Override
	@Transactional  //取得報名者Email
	public String getJoinEmail(Integer joinid) {
		String Mail = dao.getJoinEmail(joinid);
		return Mail;
	}
	@Override
	@Transactional //更新出團狀態為已出團
	public void departureUpdateNeed(Integer needid) {
		dao.departureUpdateNeed(needid);
		
	}
	@Override
	@Transactional  //新增報名資訊
	public Integer insertJoin(ApplicationBean AB) {
		Integer insertapplicationid = dao.insertJoin(AB);
		return insertapplicationid;
	}
	@Override
	@Transactional //select NeedBean
	public NeedBean selectNeedBean(Integer needid) {
		
		return dao.selectNeedBean(needid);
	}
	@Override
	@Transactional //取得此行程報名審核中的會員
	public List<ApplicationBean> SelectJoinPeople(Integer needid) {
		
		return dao.SelectJoinPeople(needid);
	}

	@Override
	@Transactional 
	public TripBean selectTripPK(Integer tripid) {
		
		return dao.selectTripPK(tripid);
	}
	@Override
	@Transactional  //版主拒絕報名者
	public void MasterRefuse(Integer appid) {
			dao.MasterRefuse(appid);
	}
	@Override
	@Transactional  //版主接受報名者
	public void MasterAgree(Integer appid) {
		dao.MasterAgree(appid);
	}
	@Override
	@Transactional
	public List<ApplicationBean> getUserApp(Integer memberId) {
		
		return dao.getUserApp(memberId);
	}
	@Override
	@Transactional
	public List<ApplicationBean> getUserFinishApp(Integer memberId) {
		// TODO Auto-generated method stub
		return dao.getUserFinishApp(memberId);
	}
	@Override
	@Transactional
	public List<ApplicationBean> getUserPayApp(Integer memberId) {
		// TODO Auto-generated method stub
		return dao.getUserPayApp(memberId);
	}
	@Override
	@Transactional
	public List<ApplicationBean> getJoinApp(Integer needId) {
		// TODO Auto-generated method stub
		return dao.getJoinApp(needId);
	}
	@Override
	@Transactional
	public ApplicationBean getAppByPk(Integer appId) {
		// TODO Auto-generated method stub
		return dao.getAppByPk(appId);
	}
	@Override
	@Transactional
	public void updateApp(ApplicationBean appBean) {
		dao.updateApp(appBean);
	}
}

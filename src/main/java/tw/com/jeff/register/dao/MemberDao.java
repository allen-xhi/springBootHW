package tw.com.jeff.register.dao;

import java.util.List;

import tw.com.jeff.model.MemberBean;
import tw.com.jeff.ticket.model.FlightOrderBean;



public interface MemberDao {
	MemberBean queryMemberByEmail(String email);
	MemberBean queryMemberByAllEmail(String email);
	MemberBean queryMemberByPK(Integer pk);
	MemberBean queryMemberByPhone(String phone);
	List<MemberBean> queryAllMember();
	void addMember(MemberBean bean);
	void updateMember(MemberBean bean);
	MemberBean queryGoogleMember(String loginWithGoogle);
	MemberBean queryLineMember(String loginWithLine);
	MemberBean queryFacebookMember(String loginWithFacebook);
	MemberBean queryThirdLoginMember(String thirdEmail,String whichThird);
	List<FlightOrderBean> getflightOrderById(Integer userID);
}

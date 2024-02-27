package tw.com.jeff.register.service;

import java.util.List;

import tw.com.jeff.model.MemberBean;
import tw.com.jeff.ticket.model.FlightOrderBean;



public interface MemberService {
	boolean checkPassword(String email,String password);
	void addMember(MemberBean bean);
	void updateMember(MemberBean bean);
	boolean isAccountIdExist(String email);
	List<MemberBean> getAllMember();
	MemberBean queryMemberByEmail(String email);
	MemberBean queryMemberByAllEmail(String email);
	MemberBean queryMemberByPK(Integer pk);
	MemberBean queryGoogleMember(String loginWithGoogle);
	MemberBean queryLineMember(String loginWithLine);
	MemberBean queryFacebookMember(String loginWithFacebook);
	MemberBean queryThirdLoginMember(String thirdEmail,String whichThird);
	List<FlightOrderBean> getflightOrderById(Integer userID);
}

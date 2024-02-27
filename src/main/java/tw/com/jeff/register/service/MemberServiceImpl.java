package tw.com.jeff.register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.com.jeff.model.MemberBean;
import tw.com.jeff.register.dao.MemberDao;
import tw.com.jeff.ticket.model.FlightOrderBean;



@Transactional
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;

	@Override
	public boolean checkPassword(String email, String password) {
		MemberBean bean = dao.queryMemberByEmail(email);
		if (bean.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public void addMember(MemberBean bean) {
		dao.addMember(bean);
	}

	@Override
	public void updateMember(MemberBean bean) {
		dao.updateMember(bean);
	}

	@Override
	public boolean isAccountIdExist(String email) {
		MemberBean bean = dao.queryMemberByEmail(email);
		if (bean != null)
			return true;
		return false;
	}

	
	@Override
	public MemberBean queryMemberByPK(Integer pk) {
		return dao.queryMemberByPK(pk);
	}
	
	public boolean checkThirdLogin(String email, String thirdLogin) {

		return true;
	}

	@Override
	public MemberBean queryGoogleMember(String loginWithGoogle) {
		// TODO Auto-generated method stub
		return dao.queryGoogleMember(loginWithGoogle);
	}

	@Override
	public MemberBean queryLineMember(String loginWithLine) {
		// TODO Auto-generated method stub
		return dao.queryLineMember(loginWithLine);
	}

	@Override
	public MemberBean queryFacebookMember(String loginWithFacebook) {
		// TODO Auto-generated method stub
		return dao.queryFacebookMember(loginWithFacebook);
	}

	@Override
	public MemberBean queryThirdLoginMember(String thirdEmail, String whichThird) {
		// TODO Auto-generated method stub
		return dao.queryThirdLoginMember(thirdEmail, whichThird);
	}

	@Override
	public List<MemberBean> getAllMember() {
		return dao.queryAllMember();
	}

	@Override
	public MemberBean queryMemberByEmail(String email) {
		// TODO Auto-generated method stub
		return dao.queryMemberByEmail(email);
	}

	@Override
	public MemberBean queryMemberByAllEmail(String email) {
		// TODO Auto-generated method stub
		return dao.queryMemberByAllEmail(email);
	}

	@Override
	public List<FlightOrderBean> getflightOrderById(Integer userID) {
		List<FlightOrderBean> list=dao.getflightOrderById(userID);
		return list;
	}

	


}

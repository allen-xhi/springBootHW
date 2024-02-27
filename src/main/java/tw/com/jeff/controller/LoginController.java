package tw.com.jeff.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;

import tw.com.jeff.model.MemberBean;
import tw.com.jeff.register.service.MemberService;

@Controller
public class LoginController {

	private static String client_id = "22042621167-ikc0vnt83k0rd0bs4rq4ljn2578lk124.apps.googleusercontent.com";
	private static String lineClient_id = "1555069274";
	private static String lineClient_secret = "e9ee9a59776f96c8c04c903afa86d5da";

	@Autowired
	MemberService ms;

	@Autowired
	ServletContext context;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("pass login");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String loginTest(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, HttpServletRequest request) {
		System.out.println(email);
		HttpSession session = request.getSession();
		MemberBean bean = ms.queryMemberByEmail(email);
		if (bean!=null) {
				bean.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
				ms.updateMember(bean);
			if (bean.getPassword().equals(password)) {
//				MemberBean bean = ms.queryMemberByEmail(email);
				if(bean.getUserType().equals("normal")) {
				if(bean.getIsVerify()==false) {
					return "verify your email";
				}
				session.setAttribute("memberBean", bean);
				session.setAttribute("loginStatus", "true");
				return request.getContextPath();
				}else {
					session.setAttribute("memberBean", bean);
					session.setAttribute("loginStatus", "true");
					return "you are manager";
				}
			} else {
				System.out.println("password is not correct");
				session.setAttribute("loginStatus", "false");
				return "error";
			}
		} else {
			System.out.println("account is not exist");
			session.setAttribute("loginStatus", "false");
			return "account is not exist";
		}
	}

	@RequestMapping(value = "/googleLogin", method = RequestMethod.POST)
	public @ResponseBody String googleLogin(@RequestParam(name = "idTokenStr") String idTokenStr,
			HttpServletRequest request) {
		System.out.println(idTokenStr);
		HttpSession session = request.getSession();
		Map<String, String> map = new HashMap<String, String>();
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(),
				JacksonFactory.getDefaultInstance()).setAudience(Collections.singletonList(client_id)).build();
		GoogleIdToken idToken = null;
		try {
			idToken = verifier.verify(idTokenStr);
		} catch (GeneralSecurityException e) {
			System.out.println("驗證時出現GeneralSecurityException異常");
		} catch (IOException e) {
			System.out.println("驗證時出現IOException異常");
		}
		if (idToken != null) {
			System.out.println("驗證成功.");
			Payload payload = idToken.getPayload();
			String userId = payload.getSubject();
			System.out.println("User ID: " + userId);
			String email = payload.getEmail();
//			boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			String name = (String) payload.get("name");
//			String pictureUrl = (String) payload.get("picture");
//			String locale = (String) payload.get("locale");
			String familyName = (String) payload.get("family_name");
			String givenName = (String) payload.get("given_name");
			System.out.println(userId);

			MemberBean googleBean = ms.queryGoogleMember(email);
			MemberBean bean;
			if (googleBean != null) {
				session.setAttribute("memberBean", googleBean);
				session.setAttribute("loginStatus", "true");
				googleBean.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
				ms.updateMember(googleBean);
				return request.getContextPath();
			} else {
				bean = ms.queryMemberByAllEmail(email);
				if (bean == null) {
					System.out.println("bean == null");
					map.put("lastName", familyName);
					map.put("firstName", givenName);
					map.put("email", email);
					map.put("name", name);
					map.put("thirdLoginType", "google");
					session.setAttribute("thirdLoginInfo", map);
					return "thirdLoginRegister";
				} else {
					session.setAttribute("memberBean", bean);
					session.setAttribute("loginStatus", "true");
					bean.setLoginWithGoogle(email);
					bean.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
					ms.updateMember(bean);
					return request.getContextPath();
				}
			}

		} else {
			System.out.println("Invalid ID token.");
		}
		return "account not exist";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/fbLogin")
	@ResponseBody
	public String fbLogin(@RequestParam("userInfo") String userInfo, HttpServletRequest request,Model model) {
		System.out.println("===================================================FB");
		Map<String, String> map = new Gson().fromJson(userInfo, Map.class);
		Map<String, String> sessionMap = new HashMap<String, String>();
		HttpSession session = request.getSession();
		String email = map.get("email");
		MemberBean fbBean = ms.queryFacebookMember(email);
		MemberBean bean;
		if (fbBean != null) {
			session.setAttribute("memberBean", fbBean);
			session.setAttribute("loginStatus", "true");
			fbBean.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
			ms.updateMember(fbBean);
			return request.getContextPath();
		} else {
			bean = ms.queryMemberByAllEmail(email);
			if (bean == null) {
				System.out.println("bean == null");
				sessionMap.put("lastName", map.get("lastName"));
				sessionMap.put("firstName", map.get("firstName"));
				sessionMap.put("email", email);
				sessionMap.put("name", map.get("name"));
				sessionMap.put("thirdLoginType", "fb");
				session.setAttribute("thirdLoginInfo", sessionMap);
				model.addAttribute("bean",new MemberBean());
				model.addAttribute("thirdLoginInfo",sessionMap);
				return "thirdLoginRegister";
			} else {
				session.setAttribute("memberBean", bean);
				session.setAttribute("loginStatus", "true");
				bean.setLoginWithFB(email);
				bean.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
				ms.updateMember(bean);
				return request.getContextPath();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/lineLogin")
	public String lineLogin(@RequestParam("code") String code, @RequestParam("state") String state, HttpServletRequest request,Model model) {
		System.out.println(code);
		String url = "https://api.line.me/oauth2/v2.1/token";
		HttpSession session = request.getSession();
		Map<String, String> sessionMap = new HashMap<String, String>();
		// 建立HttpClient
		DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
		// 建立HttpPost
		HttpPost httpPost = new HttpPost(url);
		// 建立要送的資料參數
		ArrayList<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("grant_type", "authorization_code"));
		params.add(new BasicNameValuePair("code", code));
		params.add(new BasicNameValuePair("client_id", lineClient_id));
		params.add(new BasicNameValuePair("client_secret", lineClient_secret));
		params.add(new BasicNameValuePair("redirect_uri", "http://localhost:8081/FinalProject/lineLogin"));
		// 將資料參數放到HttpPost的Entity裡面，並指定編碼
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			// Execute連線發送訊息並取得回應
			HttpResponse response = defaultHttpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if(entity!=null) {
				String responseString = EntityUtils.toString(entity, "UTF-8");
				System.out.println(responseString);
				Map<String, String> map = new Gson().fromJson(responseString, Map.class);
				DecodedJWT jwt = JWT.decode(map.get("id_token"));
				Map<String,Claim> lineMap = jwt.getClaims();
				String email = lineMap.get("email").asString();
//				System.out.println(lineMap.get("name").asString());
//				System.out.println(lineMap.get("email").asString());
//				System.out.println(lineMap.get("picture").asString());
				MemberBean lineBean = ms.queryLineMember(email);
				MemberBean bean;
				if (lineBean != null) {
					session.setAttribute("memberBean", lineBean);
					session.setAttribute("loginStatus", "true");
					lineBean.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
					ms.updateMember(lineBean);
					return "Home";
				} else {
					bean = ms.queryMemberByAllEmail(email);
					if (bean == null) {
						System.out.println("bean == null");
						sessionMap.put("lastName", "");
						sessionMap.put("firstName", "");
						sessionMap.put("email", email);
						sessionMap.put("name", lineMap.get("name").asString());
						sessionMap.put("thirdLoginType", "line");
						session.setAttribute("thirdLoginInfo", sessionMap);
						model.addAttribute("bean",new MemberBean());
						model.addAttribute("thirdLoginInfo", sessionMap);
						return "thirdLoginRegister";
					} else {
						session.setAttribute("memberBean", bean);
						session.setAttribute("loginStatus", "true");
						bean.setLoginWithLine(email);
						bean.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
						ms.updateMember(bean);
						return "Home";
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	
}

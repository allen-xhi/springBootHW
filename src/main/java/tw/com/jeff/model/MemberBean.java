package tw.com.jeff.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class MemberBean {
	private Integer id; 		// 流水號
//	private String account; 	// 帳號
	private String password;
	private String memberName; 	// 姓名
	private String lastName; 	// 姓
	private String firstName; 	// 名
	private String phone; 		// 手機
	private Date birth;
	private Byte gender;
	private String email;
//	private Blob photo;
	private String introduction;
	private String loginWithFB;
	private String loginWithLine;
	private String loginWithGoogle;
	private String userType;
	private Boolean isVerify = false; // 驗證email
	private UUID uuid; // 驗證碼
	private Timestamp registerTime;
	private Timestamp lastLoginTime;
//	private Boolean loginStatus = false;

	public MemberBean() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	@Column(unique=true)
//	public String getAccount() {
//		return account;
//	}
//
//	public void setAccount(String account) {
//		this.account = account;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Column(nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(unique = true, nullable = false)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	@Column(unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

//	@Column(unique=true)
	public String getLoginWithFB() {
		return loginWithFB;
	}

	public void setLoginWithFB(String loginWithFB) {
		this.loginWithFB = loginWithFB;
	}

//	@Column(unique=true)
	public String getLoginWithLine() {
		return loginWithLine;
	}

	public void setLoginWithLine(String loginWithLine) {
		this.loginWithLine = loginWithLine;
	}

//	@Column(unique=true)
	public String getLoginWithGoogle() {
		return loginWithGoogle;
	}

	public void setLoginWithGoogle(String loginWithGoogle) {
		this.loginWithGoogle = loginWithGoogle;
	}

	@Column(nullable = false)
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(nullable = false)
	public Boolean getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(Boolean isVerify) {
		this.isVerify = isVerify;
	}

	@Column(nullable = false)
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@Column(nullable = false)
	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

//	public Boolean getLoginStatus() {
//		return loginStatus;
//	}
//
//	public void setLoginStatus(Boolean loginStatus) {
//		this.loginStatus = loginStatus;
//	}
}

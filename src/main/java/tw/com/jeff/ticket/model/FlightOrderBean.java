package tw.com.jeff.ticket.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

import tw.com.jeff.model.MemberBean;

@Entity
@Table(name = "FlightOrder")
public class FlightOrderBean implements Serializable {
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flightOrderID;
	private java.util.Date orderDate;
	private Integer adultCount;
	private Integer adultPrice;
	private Integer adultEquipFare;
	private Integer adultTax;
	private Integer childCount;
	private Integer childPrice;
	private Integer childEquipFare;
	private Integer childTax;
	private Integer orderTotalAmount;
	@Column(columnDefinition = "nvarchar(50)")
	private String contactorFirstName;
	@Column(columnDefinition = "nvarchar(50)")
	private String contactorLastName;
	@Column(columnDefinition = "varchar(20)")
	private String contactorTel;
	@Column(columnDefinition = "varchar(50)")
	private String contactorEmail;
	@Column(columnDefinition = "char(6)")
	private String orderCode;
//	private Integer memberDiscount;

//	private Integer userID;
	private Integer orderStatusID;
	private Character cabin;
	
	@OneToMany(mappedBy = "flightOrderID")
	private Set<FlightOrderDetailBean> flightOrderDetailBeans;
	
//	@ManyToOne
//	@JoinColumn(name = "id", insertable = false, updatable = false)
//	private MemberBean memberBean;
	private Integer memberId;
	
//	@OneToMany(mappedBy = "flightOrderID")
//	private Set<PassengerBean> passengerBeans;

	

	public FlightOrderBean() {
		
	}
	public FlightOrderBean(Integer flightOrderID, Date orderDate, Integer adultCount, Integer adultPrice,
			Integer adultEquipFare, Integer adultTax, Integer childCount, Integer childPrice, Integer childEquipFare,
			Integer childTax, Integer orderTotalAmount, String contactorFirstName, String contactorLastName,
			String contactorTel, String contactorEmail, String orderCode, Integer userID, Integer orderStatusID,
			Character cabin, Set<FlightOrderDetailBean> flightOrderDetailBeans, MemberBean memberBean) {
		super();
		this.flightOrderID = flightOrderID;
		this.orderDate = orderDate;
		this.adultCount = adultCount;
		this.adultPrice = adultPrice;
		this.adultEquipFare = adultEquipFare;
		this.adultTax = adultTax;
		this.childCount = childCount;
		this.childPrice = childPrice;
		this.childEquipFare = childEquipFare;
		this.childTax = childTax;
		this.orderTotalAmount = orderTotalAmount;
		this.contactorFirstName = contactorFirstName;
		this.contactorLastName = contactorLastName;
		this.contactorTel = contactorTel;
		this.contactorEmail = contactorEmail;
		this.orderCode = orderCode;
//		this.userID = userID;
		this.orderStatusID = orderStatusID;
		this.cabin = cabin;
		this.flightOrderDetailBeans = flightOrderDetailBeans;
	}


	public Integer getFlightOrderID() {
		return flightOrderID;
	}


	public void setFlightOrderID(Integer flightOrderID) {
		this.flightOrderID = flightOrderID;
	}


	public java.util.Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}


	public Integer getAdultCount() {
		return adultCount;
	}


	public void setAdultCount(Integer adultCount) {
		this.adultCount = adultCount;
	}


	public Integer getAdultPrice() {
		return adultPrice;
	}


	public void setAdultPrice(Integer adultPrice) {
		this.adultPrice = adultPrice;
	}


	public Integer getAdultEquipFare() {
		return adultEquipFare;
	}


	public void setAdultEquipFare(Integer adultEquipFare) {
		this.adultEquipFare = adultEquipFare;
	}


	public Integer getAdultTax() {
		return adultTax;
	}


	public void setAdultTax(Integer adultTax) {
		this.adultTax = adultTax;
	}


	public Integer getChildCount() {
		return childCount;
	}


	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}


	public Integer getChildPrice() {
		return childPrice;
	}


	public void setChildPrice(Integer childPrice) {
		this.childPrice = childPrice;
	}


	public Integer getChildEquipFare() {
		return childEquipFare;
	}


	public void setChildEquipFare(Integer childEquipFare) {
		this.childEquipFare = childEquipFare;
	}


	public Integer getChildTax() {
		return childTax;
	}


	public void setChildTax(Integer childTax) {
		this.childTax = childTax;
	}


	public Integer getOrderTotalAmount() {
		return orderTotalAmount;
	}


	public void setOrderTotalAmount(Integer orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}


	public String getContactorFirstName() {
		return contactorFirstName;
	}


	public void setContactorFirstName(String contactorFirstName) {
		this.contactorFirstName = contactorFirstName;
	}


	public String getContactorLastName() {
		return contactorLastName;
	}


	public void setContactorLastName(String contactorLastName) {
		this.contactorLastName = contactorLastName;
	}


	public String getContactorTel() {
		return contactorTel;
	}


	public void setContactorTel(String contactorTel) {
		this.contactorTel = contactorTel;
	}


	public String getContactorEmail() {
		return contactorEmail;
	}


	public void setContactorEmail(String contactorEmail) {
		this.contactorEmail = contactorEmail;
	}


	public String getOrderCode() {
		return orderCode;
	}


	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


//	public Integer getMemberDiscount() {
//		return memberDiscount;
//	}
//
//
//	public void setMemberDiscount(Integer memberDiscount) {
//		this.memberDiscount = memberDiscount;
//	}


//	public Integer getUserID() {
//		return userID;
//	}
//
//
//	public void setUserID(Integer userID) {
//		this.userID = userID;
//	}


	public Integer getOrderStatusID() {
		return orderStatusID;
	}


	public void setOrderStatusID(Integer orderStatusID) {
		this.orderStatusID = orderStatusID;
	}


	public Character getCabin() {
		return cabin;
	}


	public void setCabin(Character cabin) {
		this.cabin = cabin;
	}
	
	

	public Set<FlightOrderDetailBean> getFlightOrderDetailBeans() {
		return flightOrderDetailBeans;
	}


	public void setFlightOrderDetailBeans(Set<FlightOrderDetailBean> flightOrderDetailBeans) {
		this.flightOrderDetailBeans = flightOrderDetailBeans;
	}
	
	


//	public MemberBean getMemberBean() {
//		return memberBean;
//	}
//
//
//	public void setMemberBean(MemberBean memberBean) {
//		this.memberBean = memberBean;
//	}
//	
	


	@Override
	public String toString() {
		return "FlightOrderBean [flightOrderID=" + flightOrderID + ", orderDate=" + orderDate + ", adultCount="
				+ adultCount + ", adultPrice=" + adultPrice + ", adultEquipFare=" + adultEquipFare + ", adultTax="
				+ adultTax + ", childCount=" + childCount + ", childPrice=" + childPrice + ", childEquipFare="
				+ childEquipFare + ", childTax=" + childTax + ", orderTotalAmount=" + orderTotalAmount
				+ ", contactorFirstName=" + contactorFirstName + ", contactorLastName=" + contactorLastName
				+ ", contactorTel=" + contactorTel + ", contactorEmail=" + contactorEmail + ", orderCode=" + orderCode
				+", orderStatusID=" + orderStatusID
				+ ", cabin=" + cabin + "]";
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	

}

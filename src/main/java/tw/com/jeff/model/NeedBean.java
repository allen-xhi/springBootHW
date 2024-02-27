package tw.com.jeff.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Need")
public class NeedBean {
		private Integer needId;
		private Integer requiredPeople;
		private Date DepartureTime;
		private Date ComebackTime;
		private Integer budget;
		private String CustomDemand;
		TripBean tripBean;
		MemberBean memberBean;
//		private Integer tripid = 1;
		private Date deadline;
		private Integer whetherFull;
		private Integer NoPayGoOrNot;
		private Integer goOrNot = 0;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public Integer getNeedId() {
			return needId;
		}
		
		public void setNeedId(Integer needId) {
			this.needId = needId;
		}
		@ManyToOne(cascade=CascadeType.ALL) 
		@JoinColumn(name="FK_tripId")
		public TripBean getTripBean() {
			return tripBean;
		}
		public void setTripBean(TripBean tripBean) {
			this.tripBean = tripBean;
		}

		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="FK_memberId")
		public MemberBean getMemberBean() {
			return memberBean;
		}

		public void setMemberBean(MemberBean memberBean) {
			this.memberBean = memberBean;
		}

		public Integer getRequiredPeople() {
			return requiredPeople;
		}

		
//		public Integer getTripid() {
//			return tripid;
//		}
//
//		public void setTripid(Integer tripid) {
//			this.tripid = tripid;
//		}

		public void setRequiredPeople(Integer requiredPeople) {
			this.requiredPeople = requiredPeople;
		}
		public java.sql.Date getDepartureTime() {
			return DepartureTime;
		}
		public void setDepartureTime(java.sql.Date departureTime) {
			DepartureTime = departureTime;
		}
		public java.sql.Date getComebackTime() {
			return ComebackTime;
		}
		public void setComebackTime(java.sql.Date comebackTime) {
			ComebackTime = comebackTime;
		}
		public Integer getBudget() {
			return budget;
		}
		public void setBudget(Integer budget) {
			this.budget = budget;
		}
		public String getCustomDemand() {
			return CustomDemand;
		}
		public void setCustomDemand(String customDemand) {
			CustomDemand = customDemand;
		}
		public java.sql.Date getDeadline() {
			return deadline;
		}
		public void setDeadline(java.sql.Date deadline) {
			this.deadline = deadline;
		}

		public Integer getWhetherFull() {
			return whetherFull;
		}

		public void setWhetherFull(Integer whetherFull) {
			this.whetherFull = whetherFull;
		}

		public Integer getNoPayGoOrNot() {
			return NoPayGoOrNot;
		}

		public void setNoPayGoOrNot(Integer noPayGoOrNot) {
			NoPayGoOrNot = noPayGoOrNot;
		}

		public Integer getGoOrNot() {
			return goOrNot;
		}

		public void setGoOrNot(Integer goOrNot) {
			this.goOrNot = goOrNot;
		}
    
			      
}

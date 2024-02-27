package tw.com.jeff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="application")
public class ApplicationBean {
	private Integer appId;
	private Integer hostAgreeOrNot =0;
	NeedBean needBean;
	MemberBean memberBean;
	private Integer buyTicket = 0;	// 0 : 未確認   1:利用本網站購買   2:自行購買   3:不買 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public Integer getHostAgreeOrNot() {
		return hostAgreeOrNot;
	}
	public void setHostAgreeOrNot(Integer hostAgreeOrNot) {
		this.hostAgreeOrNot = hostAgreeOrNot;
	}
	@ManyToOne
	@JoinColumn(name="FK_NeedId")
	public NeedBean getNeedBean() {
		return needBean;
	}
	public void setNeedBean(NeedBean needBean) {
		this.needBean = needBean;
	}
	@ManyToOne
	@JoinColumn(name="FK_memberId")
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	public Integer getBuyTicket() {
		return buyTicket;
	}
	public void setBuyTicket(Integer buyTicket) {
		this.buyTicket = buyTicket;
	}
	
}

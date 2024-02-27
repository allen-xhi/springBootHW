package tw.com.jeff.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tw.com.jeff.model.NeedBean;
import tw.com.jeff.model.MemberBean;
@Entity
@Table(name="MessageBoard")
public class Boardmessage {
	NeedBean needBean;
	MemberBean memberBean;
	private String Sentence;
	private  java.util.Date Time;
	private Integer BmsId;

	
	public Boardmessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Boardmessage(NeedBean needBean, MemberBean memberBean, String sentence, Date time) {
		this.needBean = needBean;
		this.memberBean = memberBean;
		Sentence = sentence;
		Time = time;
	}

	@ManyToOne
	@JoinColumn(name="FK_memberid")
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	@ManyToOne
	@JoinColumn(name="FK_needid")
	public NeedBean getNeedBean() {
		return needBean;
	}
	public void setNeedBean(NeedBean needBean) {
		this.needBean = needBean;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getBmsId() {
		return BmsId;
	}
	public void setBmsId(Integer bmsId) {
		BmsId = bmsId;
	}


//	public String getAccountId() {
//		return AccountId;
//	}
//	public void setAccountId(String accountId) {
//		AccountId = accountId;
//	}
	public String getSentence() {
		return Sentence;
	}
	public void setSentence(String sentence) {
		Sentence = sentence;
	}
	public java.util.Date getTime() {
		return Time;
	}
	public void setTime(java.util.Date time) {
		Time = time;
	}

}

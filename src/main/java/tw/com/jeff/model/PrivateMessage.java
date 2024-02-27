package tw.com.jeff.model;

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

@Entity
@Table(name="PrivateMessage")
public class PrivateMessage {
private String Sentence;
private  java.util.Date Time;
private String AccountId;
private String toAccountId;
private boolean isreadornot;
private int pmsid;
private String chatroomname;
private Integer memberId;

public String getChatroomname() {
	return chatroomname;
}
public void setChatroomname(String chatroomname) {
	this.chatroomname = chatroomname;
}
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public int getPmsid() {
	return pmsid;
}
public void setPmsid(int pmsid) {
	this.pmsid = pmsid;
}
public PrivateMessage() {	
}
public PrivateMessage(String Sentence,java.util.Date Time,String AccountId, String toAccountId, boolean isreadornot,String chatroomname) {
this.Sentence=Sentence;
this.Time=Time;
this.AccountId=AccountId;
this.toAccountId=toAccountId;
this.isreadornot=isreadornot;
this.chatroomname=chatroomname;
}
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
public String getAccountId() {
	return AccountId;
}

public void setAccountId(String accountId) {
	AccountId = accountId;
}

public boolean isIsreadornot() {
	return isreadornot;
}
public void setIsreadornot(boolean isreadornot) {
	this.isreadornot = isreadornot;
}

public String getToAccountId() {
	return toAccountId;
}
public void setToAccountId(String toAccountId) {
	this.toAccountId = toAccountId;
}
@Column(name="fk_id")
public Integer getMemberId() {
	return memberId;
}
public void setMemberId(Integer memberId) {
	this.memberId = memberId;
}

}

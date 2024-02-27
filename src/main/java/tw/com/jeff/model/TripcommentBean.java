package tw.com.jeff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tripcmm")
public class TripcommentBean {
private Integer TripcommentId;
private Integer tripbean;
private Double StarNum;
private String comment;

public Integer getTripbean() {
	return tripbean;
}

public void setTripbean(Integer tripbean) {
	this.tripbean = tripbean;
}

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public Integer getTripcommentId() {
	return TripcommentId;
}
public void setTripcommentId(Integer tripcommentId) {
	TripcommentId = tripcommentId;
}
public Double getStarNum() {
	return StarNum;
}
public void setStarNum(Double starNum) {
	StarNum = starNum;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}


}

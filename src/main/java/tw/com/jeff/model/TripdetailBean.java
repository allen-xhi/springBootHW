package tw.com.jeff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import tw.com.jeff.google.model.CustomerSceneryBean;

@Entity
@Table(name="tripdetail")
public class TripdetailBean {
	private Integer TripDetailId;
	private Integer whichday;
	private Integer orderby;
	TripBean tripbean;
	SceneryBean sceneryBean;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTripDetailId() {
		return TripDetailId;
	}
	public void setTripDetailId(Integer tripDetailId) {
		TripDetailId = tripDetailId;
	}

	public Integer getWhichday() {
		return whichday;
	}
	public void setWhichday(Integer whichday) {
		this.whichday = whichday;
	}
	public Integer getOrderby() {
		return orderby;
	}
	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}
	@ManyToOne
	@JoinColumn(name="FK_tripid")
	public TripBean getTripbean() {
		return tripbean;
	}
	public void setTripbean(TripBean tripbean) {
		this.tripbean = tripbean;
	}
	@ManyToOne
	@JoinColumn(name="FK_viewid")
	public SceneryBean getSceneryBean() {
		return sceneryBean;
	}
	public void setSceneryBean(SceneryBean sceneryBean) {
		this.sceneryBean = sceneryBean;
	}

	
}

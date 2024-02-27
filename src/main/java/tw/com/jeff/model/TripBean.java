package tw.com.jeff.model;


import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="trip")
public class TripBean {
	private Integer tripId;
	private String tripname;
	private Blob photo;
	private String triptype;
	private String countrycity;
	private Integer tripdays;
	private Integer lowestprice;
	private MultipartFile packageImage;
	private String fileName;
//	NeedBean needBean;
	public TripBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TripBean(Integer tripId, String tripname, Blob photo, String triptype, String countrycity, Integer tripdays,
		Integer lowestprice) {
	super();
	this.tripId = tripId;
	this.tripname = tripname;
	this.photo = photo;
	this.triptype = triptype;
	this.countrycity = countrycity;
	this.tripdays = tripdays;
	this.lowestprice = lowestprice;
}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getTripname() {
		return tripname;
	}

//	public NeedBean getNeedBean() {
//		return needBean;
//	}
//	public void setNeedBean(NeedBean needBean) {
//		this.needBean = needBean;
//	}
	public void setTripname(String tripname) {
		this.tripname = tripname;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	public String getTriptype() {
		return triptype;
	}
	public void setTriptype(String triptype) {
		this.triptype = triptype;
	}
	public String getCountrycity() {
		return countrycity;
	}
	public void setCountrycity(String countrycity) {
		this.countrycity = countrycity;
	}
	public Integer getTripdays() {
		return tripdays;
	}
	public void setTripdays(int tripdays) {
		this.tripdays = tripdays;
	}
	public Integer getLowestprice() {
		return lowestprice;
	}
	public void setLowestprice(Integer lowestprice) {
		this.lowestprice = lowestprice;
	}
	@Transient
	public MultipartFile getPackageImage() {
		return packageImage;
	}
	public void setPackageImage(MultipartFile packageImage) {
		this.packageImage = packageImage;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}

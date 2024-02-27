package tw.com.jeff.ticket.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "city")
public class AirportBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String cityid;
	private String cityname;
	
	@OneToMany(mappedBy = "departurePlace")
	@JsonIgnore
	private Set<FlightOrderDetailBean> departurePlaceBeans;

	@OneToMany(mappedBy = "arrivalPlace")
	@JsonIgnore
	private Set<FlightOrderDetailBean> arrivalPlaceBeans;
	
	public AirportBean() {
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Set<FlightOrderDetailBean> getDeparturePlaceBeans() {
		return departurePlaceBeans;
	}

	public void setDeparturePlaceBeans(Set<FlightOrderDetailBean> departurePlaceBeans) {
		this.departurePlaceBeans = departurePlaceBeans;
	}

	public Set<FlightOrderDetailBean> getArrivalPlaceBeans() {
		return arrivalPlaceBeans;
	}

	public void setArrivalPlaceBeans(Set<FlightOrderDetailBean> arrivalPlaceBeans) {
		this.arrivalPlaceBeans = arrivalPlaceBeans;
	}

	public AirportBean(String cityid, String cityname) {
		super();
		this.cityid = cityid;
		this.cityname = cityname;
	}
	
	

	@Override
	public String toString() {
		return "AirportBean [cityid=" + cityid + ", cityname=" + cityname + "]";
	}
	
	
	
	
}

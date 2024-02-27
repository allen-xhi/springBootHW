package tw.com.jeff.ticket.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="airline")
public class AirlineBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String airlineid;
	
	private String airlinename;
	
	@OneToMany(mappedBy = "airlineid")
	private Set<FlightOrderDetailBean> flightOrderDetailBeans;

	public AirlineBean() {
	}
	
	public AirlineBean(String airlineid, String airlinename) {
		super();
		this.airlineid = airlineid;
		this.airlinename = airlinename;
	}

	public String getAirlineid() {
		return airlineid;
	}

	public void setAirlineid(String airlineid) {
		this.airlineid = airlineid;
	}

	public String getAirlinename() {
		return airlinename;
	}

	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}

	public Set<FlightOrderDetailBean> getFlightOrderDetailBeans() {
		return flightOrderDetailBeans;
	}

	public void setFlightOrderDetailBeans(Set<FlightOrderDetailBean> flightOrderDetailBeans) {
		this.flightOrderDetailBeans = flightOrderDetailBeans;
	}
	
	
	
	

}

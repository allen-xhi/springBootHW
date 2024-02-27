package tw.com.jeff.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flightprice")
public class FlightpriceBean {

	private Integer FlightpriceId;
	private String departure;
	private String destination;
	private Double addpercent;
	private Integer addprice;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getFlightpriceId() {
		return FlightpriceId;
	}
	public void setFlightpriceId(Integer flightpriceId) {
		FlightpriceId = flightpriceId;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getAddpercent() {
		return addpercent;
	}
	public void setAddpercent(Double addpercent) {
		this.addpercent = addpercent;
	}
	public Integer getAddprice() {
		return addprice;
	}
	public void setAddprice(Integer addprice) {
		this.addprice = addprice;
	}
	
}

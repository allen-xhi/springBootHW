package tw.com.jeff.ticket.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

@Entity
@Table(name = "FlightOrderDetail")
public class FlightOrderDetailBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer flightOrderDetailID;
	private Integer travelFlag;
	@Column(columnDefinition = "date")
	private java.util.Date departureDate;
	@Column(columnDefinition = "time")
	private java.util.Date departureTime;
	@Column(columnDefinition = "date")
	private java.util.Date arrivalDate;
	@Column(columnDefinition = "time")
	private java.util.Date arrivalTime;
	@Column(columnDefinition = "varchar(5)")
	private String flightNumber;
	@Column(columnDefinition = "nvarchar(10)")
	private String elapsedTime;
	@Column(columnDefinition = "varchar(5)")
	private String equipType;

	private Integer flightOrderID;
	@Column(columnDefinition = "char(3)")
	private String departurePlace;
	@Column(columnDefinition = "char(3)")
	private String arrivalPlace;
	@Column(columnDefinition = "char(2)")
	private String airlineid;
	
	
	
	@ManyToOne
	@JoinColumn(name = "flightOrderID", insertable = false, updatable = false)
	private FlightOrderBean flightOrderBean;
	
	@ManyToOne
	@JoinColumn(name = "airlineid", insertable = false, updatable = false)
	private AirlineBean airlineBean;
	
	@ManyToOne
	@JoinColumn(name = "departurePlace", insertable = false, updatable = false)
	private AirportBean departurePlaceBean;
	
	@ManyToOne
	@JoinColumn(name = "arrivalPlace", insertable = false, updatable = false)
	private AirportBean arrivalPlaceBean;

	public FlightOrderDetailBean() {
	}

	public FlightOrderDetailBean(Integer flightOrderDetailID, Integer travelFlag, Date departureDate,
			Date departureTime, Date arrivalDate, Date arrivalTime, String flightNumber, String elapsedTime,
			String equipType, Integer flightOrderID, String departurePlace, String arrivalPlace, String airlineid) {
		super();
		this.flightOrderDetailID = flightOrderDetailID;
		this.travelFlag = travelFlag;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.flightNumber = flightNumber;
		this.elapsedTime = elapsedTime;
		this.equipType = equipType;
		this.flightOrderID = flightOrderID;
		this.departurePlace = departurePlace;
		this.arrivalPlace = arrivalPlace;
		this.airlineid = airlineid;
	}

	public Integer getFlightOrderDetailID() {
		return flightOrderDetailID;
	}

	public void setFlightOrderDetailID(Integer flightOrderDetailID) {
		this.flightOrderDetailID = flightOrderDetailID;
	}

	public Integer getTravelFlag() {
		return travelFlag;
	}

	public void setTravelFlag(Integer travelFlag) {
		this.travelFlag = travelFlag;
	}

	public java.util.Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(java.util.Date departureDate) {
		this.departureDate = departureDate;
	}

	public java.util.Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(java.util.Date departureTime) {
		this.departureTime = departureTime;
	}

	public java.util.Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(java.util.Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public java.util.Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(java.util.Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public String getEquipType() {
		return equipType;
	}

	public void setEquipType(String equipType) {
		this.equipType = equipType;
	}

	public Integer getFlightOrderID() {
		return flightOrderID;
	}

	public void setFlightOrderID(Integer flightOrderID) {
		this.flightOrderID = flightOrderID;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public void setDeparturePlace(String departurePlace) {
		this.departurePlace = departurePlace;
	}

	public String getArrivalPlace() {
		return arrivalPlace;
	}

	public void setArrivalPlace(String arrivalPlace) {
		this.arrivalPlace = arrivalPlace;
	}

	public String getAirlineid() {
		return airlineid;
	}

	public void setAirlineid(String airlineid) {
		this.airlineid = airlineid;
	}
	
	
	
	public FlightOrderBean getFlightOrderBean() {
		return flightOrderBean;
	}

	public void setFlightOrderBean(FlightOrderBean flightOrderBean) {
		this.flightOrderBean = flightOrderBean;
	}

	public AirportBean getDeparturePlaceBean() {
		return departurePlaceBean;
	}

	public void setDeparturePlaceBean(AirportBean departurePlaceBean) {
		this.departurePlaceBean = departurePlaceBean;
	}

	public AirportBean getArrivalPlaceBean() {
		return arrivalPlaceBean;
	}

	public void setArrivalPlaceBean(AirportBean arrivalPlaceBean) {
		this.arrivalPlaceBean = arrivalPlaceBean;
	}

	
	
	public AirlineBean getAirlineBean() {
		return airlineBean;
	}

	public void setAirlineBean(AirlineBean airlineBean) {
		this.airlineBean = airlineBean;
	}

	@Override
	public String toString() {
		return "FlightOrderDetailBean [flightOrderDetailID=" + flightOrderDetailID + ", travelFlag=" + travelFlag
				+ ", departureDate=" + departureDate + ", departureTime=" + departureTime + ", arrivalDate="
				+ arrivalDate + ", arrivalTime=" + arrivalTime + ", flightNumber=" + flightNumber + ", elapsedTime="
				+ elapsedTime + ", equipType=" + equipType + ", flightOrderID=" + flightOrderID + ", departurePlace="
				+ departurePlace + ", arrivalPlace=" + arrivalPlace + ", airLineid=" + airlineid + "]";
	}
	
	
}

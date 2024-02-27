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

@Entity
@Table(name="Passenger")
public class PassengerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer passengerID;
	@Column(columnDefinition = "nvarchar(50)")
	private String chFirstName;
	@Column(columnDefinition = "nvarchar(50)")
	private String chLastName;
	@Column(columnDefinition = "varchar(50)")
	private String firstName;
	@Column(columnDefinition = "varchar(50)")
	private String lastName;
	@Column(columnDefinition = "char(1)")
	private Character gender;
	@Column(columnDefinition = "char(1)")
	private Character passengerType;
	@Column(columnDefinition = "date")
	private java.util.Date bornDate;
	
	private Integer flightOrderID;
	
	@ManyToOne
	@JoinColumn(name = "flightOrderID", insertable = false, updatable = false)
	private FlightOrderBean flightOrderBean;

	public PassengerBean() {		
	}

	public PassengerBean(Integer passengerID, String chFirstName, String chLastName, String firstName, String lastName,
			Character gender, Character passengerType, Date bornDate, Integer flightOrderID,
			FlightOrderBean flightOrderBean) {
		this.passengerID = passengerID;
		this.chFirstName = chFirstName;
		this.chLastName = chLastName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.passengerType = passengerType;
		this.bornDate = bornDate;
		this.flightOrderID = flightOrderID;
		this.flightOrderBean = flightOrderBean;
	}

	public Integer getPassengerID() {
		return passengerID;
	}

	public void setPassengerID(Integer passengerID) {
		this.passengerID = passengerID;
	}

	public String getChFirstName() {
		return chFirstName;
	}

	public void setChFirstName(String chFirstName) {
		this.chFirstName = chFirstName;
	}

	public String getChLastName() {
		return chLastName;
	}

	public void setChLastName(String chLastName) {
		this.chLastName = chLastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Character getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(Character passengerType) {
		this.passengerType = passengerType;
	}

	public java.util.Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(java.util.Date bornDate) {
		this.bornDate = bornDate;
	}

	public Integer getFlightOrderID() {
		return flightOrderID;
	}

	public void setFlightOrderID(Integer flightOrderID) {
		this.flightOrderID = flightOrderID;
	}

	public FlightOrderBean getFlightOrderBean() {
		return flightOrderBean;
	}

	public void setFlightOrderBean(FlightOrderBean flightOrderBean) {
		this.flightOrderBean = flightOrderBean;
	}

	@Override
	public String toString() {
		return "PassengerBean [passengerID=" + passengerID + ", chFirstName=" + chFirstName + ", chLastName="
				+ chLastName + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", passengerType=" + passengerType + ", bornDate=" + bornDate + ", flightOrderID=" + flightOrderID
				+ ", flightOrderBean=" + flightOrderBean + "]";
	}
	
	

}

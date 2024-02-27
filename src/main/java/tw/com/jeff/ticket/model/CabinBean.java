package tw.com.jeff.ticket.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cabin")
public class CabinBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Character cabinid;
	private String cabinname;

	public  CabinBean() {
		
	}

	public CabinBean(Character cabinid, String cabinname) {
		super();
		this.cabinid = cabinid;
		this.cabinname = cabinname;
	}

	public Character getCabinid() {
		return cabinid;
	}

	public void setCarbinid(Character cabinid) {
		this.cabinid = cabinid;
	}

	public String getCabinname() {
		return cabinname;
	}

	public void setCarbinname(String cabinname) {
		this.cabinname = cabinname;
	}

	@Override
	public String toString() {
		return "CabinBean [cabinid=" + cabinid + ", cabinname=" + cabinname + "]";
	}
	
	
	

}

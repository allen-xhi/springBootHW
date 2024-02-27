package tw.com.jeff.google.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerscenery")
public class CustomerSceneryBean {
	
	private Integer viewid;
	private String name;
	private String address;
	private String city;
	private String country;
	
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getViewid() {
		return viewid;
	}
	public void setViewid(Integer viewid) {
		this.viewid = viewid;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public CustomerSceneryBean(Integer viewid, String name, String address, String city, String country) {
		
		this.viewid = viewid;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	
	public CustomerSceneryBean() {
	
	}
	
	
}

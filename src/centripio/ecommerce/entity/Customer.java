package centripio.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
//@SequenceGenerator(name="customer_sec", sequenceName="customer_sec", initialValue=1, allocationSize=1 )
public class Customer {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_sec" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firtname;
	private String lastname;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirtname() {
		return firtname;
	}
	public void setFirtname(String firtname) {
		this.firtname = firtname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}

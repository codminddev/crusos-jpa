package centripio.ecommerce.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
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
	@Column(name="id")
	private Long id;
	
	@Column(name="firt_name", length=30, nullable=false, updatable=false, unique=true)
	private String firtname;
	
	@Column(name="last_name", length=50, insertable=false)
	private String lastname;
	
	@Column(name="number", precision=10, scale=4)
	private Float number;
	
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

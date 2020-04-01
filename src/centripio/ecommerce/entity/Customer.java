package centripio.ecommerce.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import centripio.ecommerce.entity.enums.CustomerStatus;

@Entity
@Table(name="customers")
//@SequenceGenerator(name="customer_sec", sequenceName="customer_sec", initialValue=1, allocationSize=1 )
public class Customer {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_sec" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="firt_name", length=30, nullable=false)
	private String firtname;
	
	@Column(name="last_name", length=50, nullable=false)
	private String lastname;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="birthday", nullable=false)
	private LocalDate birthday;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_date", nullable=false, updatable=false)
	private LocalDateTime regDate = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false, length=8)
	private CustomerStatus status;
	
	
	
	public CustomerStatus getStatus() {
		return status;
	}
	public void setStatus(CustomerStatus status) {
		this.status = status;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
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

package orderapi.ecommerce.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.jboss.logging.Logger;

import orderapi.ecommerce.entity.enums.CustomerStatus;

@Entity
@Table(name="customers")
//@SequenceGenerator(name="customer_sec", sequenceName="customer_sec", initialValue=1, allocationSize=1 )
public class Customer implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Transient
	private static final Logger logger = Logger.getLogger(Customer.class);
	
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="customer_sec" )
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="firt_name", length=30, nullable=false)
	private String firtname;
	
	@Column(name="last_name", length=50, nullable=false)
	private String lastname;
	
	@Transient
	private String fullName;
	
	//@Temporal(TemporalType.DATE)
	@Column(name="birthday", nullable=false)
	private LocalDate birthday;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_date", nullable=false, updatable=false)
	private LocalDateTime regDate = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false, length=8)
	private CustomerStatus status = CustomerStatus.ACTIVE;
	
	@Embedded
	private Image avatar;
	
	public Image getAvatar() {
		return avatar;
	}

	public void setAvatar(Image avatar) {
		this.avatar = avatar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Logger getLogger() {
		return logger;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	private void setFullName(String fullName) {
		logger.info("fullname updated ==> " + fullName);
		this.fullName = fullName;
	}
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
		setFullName(firtname + " " + lastname);
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
		setFullName(firtname + " " + lastname);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}

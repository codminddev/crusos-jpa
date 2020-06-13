package orderapi.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import orderapi.ecommerce.entity.enums.Status;

@Entity
@Table(name="products")
public class Product {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", length=100, nullable=false)
	private String name;
	
	@Column(name="price", nullable=false)
	private Double price = 0d;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false, length=10)
	private Status status = Status.ACTIVE;
	
	@Column(name="reg_date", nullable=false, updatable=false)
	private LocalDateTime regDate;
	
	@ManyToMany
	@JoinTable(name="rel_prod_clas", 
		joinColumns= {@JoinColumn(name="fk_product")},
		inverseJoinColumns= {@JoinColumn(name="fk_clasification")}
	)
	private List<Clasification> clasifications;
	
	public void addClasification(Clasification clasification) {
		List<Clasification> clasifications = getClasifications();
		clasifications.add(clasification);
	}
	
	public List<Clasification> getClasifications() {
		if(this.clasifications == null) {
			this.clasifications = new ArrayList<Clasification>();
		}
		return clasifications;
	}

	public void setClasifications(List<Clasification> clasifications) {
		this.clasifications = clasifications;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
}

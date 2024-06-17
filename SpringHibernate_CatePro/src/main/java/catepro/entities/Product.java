package catepro.entities;

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
@Table(name= "Product")
public class Product {
@Id
@Column(name="ProId")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer proId;
@Column(name="ProName")
private String proName;
@Column(name="Producer")
private String producer;
@Column(name="YearMaking")
private Integer yearMaking;
@Column(name="ExpireDate")
private Date expireDate;
@Column(name = "Quantity")
private Integer quantity;
@Column(name = "Price")
private Integer price;

@ManyToOne
@JoinColumn(name="CateId",referencedColumnName = "CateId")
private Category cate;

public Product() {
	// TODO Auto-generated constructor stub
}

public Product(Integer proId, String proName, String producer, Integer yearMaking, Date expireDate, Integer quantity,
		Integer price, Category cate) {
	super();
	this.proId = proId;
	this.proName = proName;
	this.producer = producer;
	this.yearMaking = yearMaking;
	this.expireDate = expireDate;
	this.quantity = quantity;
	this.price = price;
	this.cate = cate;
}

public Integer getProId() {
	return proId;
}

public void setProId(Integer proId) {
	this.proId = proId;
}

public String getProName() {
	return proName;
}

public void setProName(String proName) {
	this.proName = proName;
}

public String getProducer() {
	return producer;
}

public void setProducer(String producer) {
	this.producer = producer;
}

public Integer getYearMaking() {
	return yearMaking;
}

public void setYearMaking(Integer yearMaking) {
	this.yearMaking = yearMaking;
}

public Date getExpireDate() {
	return expireDate;
}

public void setExpireDate(Date expireDate) {
	this.expireDate = expireDate;
}

public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public Integer getPrice() {
	return price;
}

public void setPrice(Integer price) {
	this.price = price;
}

public Category getCate() {
	return cate;
}

public void setCate(Category cate) {
	this.cate = cate;
}

}

package catepro.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@Column(name="CateId")
	private String cateId;
	@Column(name="CateName")
	private String cateName;
	@Column(name="Active")
	private Integer active;
	
	@OneToMany(mappedBy = "cate")
	private Set<Product> products;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String cateId, String cateName, Integer active, Set<Product> products) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
		this.active = active;
		this.products = products;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}

package catepro.dao;

import java.util.List;

import catepro.entities.Product;

public interface ProductDAO {
	public List<Product> getProducts();
	public boolean insertProduct(Product p);
	public Product Thongtinchitiet(Integer proId);
	public boolean xoaSP(Integer proId);
	public boolean updateProduct(Product p);
	public List<Product> TimKiemSP(String Search);
}

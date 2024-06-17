package catepro.dao.impl;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import catepro.dao.ProductDAO;
import catepro.entities.Product;

@Repository
public class ProductDAOimpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Product",Product.class).list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertProduct(Product p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Product Thongtinchitiet(Integer proId) {
		Session session = sessionFactory.openSession();
		try {
			Product product = session.get(Product.class, proId);
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean xoaSP(Integer proId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(Thongtinchitiet(proId));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product p) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Product> TimKiemSP(String Search) {
		if (Search == null || Search.length() == 0) {
			Search = "%";
		}else {
			Search = "%" +Search.toLowerCase() + "%";
		}
		
		Session session = sessionFactory.openSession();
		try {
			List<Product> list = session.createQuery("from Product where lower(proName) like:Search or lower(producer) like:Search")
							.setParameter("Search", Search)
							.getResultList();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}

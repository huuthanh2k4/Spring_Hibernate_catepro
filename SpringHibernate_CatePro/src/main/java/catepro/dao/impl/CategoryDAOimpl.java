package catepro.dao.impl;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import catepro.dao.CategoryDAO;
import catepro.entities.Category;

@Repository
public class CategoryDAOimpl implements CategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getCategories() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Category").list();
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

package pl.zielinska.crmdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.zielinska.crmdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = 
				session.createQuery("from Customer", Customer.class);		
		
		return theQuery.getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(theCustomer);
	}

}

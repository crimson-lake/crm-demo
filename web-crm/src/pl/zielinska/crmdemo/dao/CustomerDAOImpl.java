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
				session.createQuery("from Customer order by lastName", 
										Customer.class);		
		
		return theQuery.getResultList();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {

		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Customer.class, theId);
	}

	@Override
	public void delete(int theId) {

		Session session = sessionFactory.getCurrentSession();
		
		Customer theCustomer = session.get(Customer.class, theId);
		
		session.delete(theCustomer);
		
	}

}

package pl.zielinska.crmdemo.dao;

import java.util.List;

import pl.zielinska.crmdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void delete(int theId);

}

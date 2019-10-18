package pl.zielinska.crmdemo.service;

import java.util.List;

import pl.zielinska.crmdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void delete(int theId);
	
}

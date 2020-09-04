package com.stackroute.customer.service;

import java.util.List;

import com.stackroute.customer.exception.CustomerAlreadyExistException;
import com.stackroute.customer.model.Customer;

public interface CustomerService {

	Customer addCustomerdetails(Customer customer) throws CustomerAlreadyExistException;
	List<Customer> viewallCustomers();
}

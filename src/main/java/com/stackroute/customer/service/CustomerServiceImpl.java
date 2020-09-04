package com.stackroute.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.customer.exception.CustomerAlreadyExistException;
import com.stackroute.customer.model.Customer;
import com.stackroute.customer.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	CustomerRepo customerrepo;
	
	@Override
	public Customer addCustomerdetails(Customer customernew) throws CustomerAlreadyExistException {
		
		Optional<Customer> customerobj=customerrepo.findById(customernew.getCustid());
		
		if(customerobj.isPresent())
			throw new CustomerAlreadyExistException();
		else
			customerrepo.save(customernew);
		
		
		return customernew;
	}

	@Override
	public List<Customer> viewallCustomers() {
	
	return	customerrepo.findAll();
	}

}

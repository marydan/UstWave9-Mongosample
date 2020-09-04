package com.stackroute.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.customer.exception.CustomerAlreadyExistException;
import com.stackroute.customer.model.Customer;
import com.stackroute.customer.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerservice;
	
	
	@PostMapping("/addCustomer")
	public ResponseEntity<?> addcustomer(@RequestBody Customer customernew)
	{
		
	try {
		Customer custresult=customerservice.addCustomerdetails(customernew);
		return new ResponseEntity<Customer>(custresult,HttpStatus.CREATED);
	} 
	catch (CustomerAlreadyExistException e) {
	 return new ResponseEntity<String>("ID Already exist",HttpStatus.CONFLICT);
	}
		
	}
	
	@GetMapping("/showCustomers")
	public ResponseEntity viewCustomer()
	{
		List<Customer> customers=customerservice.viewallCustomers();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	

}

package com.stackroute.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.customer.model.Customer;


@Repository
public interface CustomerRepo extends MongoRepository<Customer,String>{

}

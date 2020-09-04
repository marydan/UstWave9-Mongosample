package com.stackroute.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.customer.model.Company;

@Repository
public interface CompanyRepo  extends MongoRepository<Company,String>{

}

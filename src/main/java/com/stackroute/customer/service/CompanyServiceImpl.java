package com.stackroute.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.customer.exception.CustomerAlreadyExistException;
import com.stackroute.customer.model.Company;
import com.stackroute.customer.model.Customer;
import com.stackroute.customer.model.Item;
import com.stackroute.customer.repository.CompanyRepo;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyRepo companyrepo;

	@Override
	public Company addCompanyDetails(Company companynew) {
		 
	Optional<Company> companyresult=companyrepo.findById(companynew.getCompnayid());
	Company companyold;
	if(companyresult.isPresent())
	{
		companyold=companyresult.get();
	   List<Item> itemsexist=companyold.getItems();
		itemsexist.addAll(companynew.getItems());
	    companyold.setItems(itemsexist);	
       companyrepo.save(companyold);
	}
	else
		companyrepo.save(companynew);
	
	return companynew;
	
	
	}

	@Override
	public List<Company> viewallCompany() {
		
		return companyrepo.findAll();
	}
	
	 

}

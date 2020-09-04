package com.stackroute.customer.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

	@Override
	public boolean deleteCompany(String companyid) {
		 
		companyrepo.deleteById(companyid);
		return true;
	}

	@Override
	public boolean deleteCompanyItem(String companyid, String itemname) {

	   Optional<Company> companyresult=companyrepo.findById(companyid);	
	   Company company;
	   if (companyresult.isPresent())
	   {
		  company=companyresult.get();
		   List<Item> items=company.getItems();
		   
       Iterator<Item> itemiterator=items.iterator();
       
         while(itemiterator.hasNext())
         {
        	 Item itemobj=itemiterator.next();
        	 
        	 if (itemobj.getItemname().equals(itemname))
        		 itemiterator.remove();
         } // remove the search item from list
         
		    company.setItems(items); // update pending list elements again with the main document
		    companyrepo.save(company);
         	   
	   }
		   
		
		return true;
	}

	@Override
	public Item findbyItemname(String companyid, String itemname) {
	Optional<Company> companyobj=companyrepo.findById(companyid);
	
	if(companyobj.isPresent())
	{
		Company companyresult=companyobj.get();
		
		List<Item> items=companyresult.getItems();
List<Item> filtered= items.stream().filter( item-> item.getItemname().equals(itemname)).collect(Collectors.toList());
		if(filtered.size()>0)
    return filtered.get(0);
		else
			return null;
	}
	else
		return null;
	}

	@Override
	public Company modifyCompanyDetails(String companyid, Item itemmodi) {
		// TODO Auto-generated method stub
		return null;
	}
	
	 

}

package com.stackroute.customer.service;

import java.util.List;

import com.stackroute.customer.model.Company;
import com.stackroute.customer.model.Item;

public interface CompanyService {

	Company addCompanyDetails(Company companynew);
	List<Company> viewallCompany();
	boolean deleteCompany(String companyid);
	boolean deleteCompanyItem(String companyid,String itemname);
	
	Item findbyItemname(String companyid,String itemname);
	
	Company modifyCompanyDetails(String companyid,Item itemmodi);
	
	
}

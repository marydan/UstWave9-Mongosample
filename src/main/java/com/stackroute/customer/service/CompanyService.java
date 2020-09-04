package com.stackroute.customer.service;

import java.util.List;

import com.stackroute.customer.model.Company;

public interface CompanyService {

	Company addCompanyDetails(Company companynew);
	List<Company> viewallCompany();
}

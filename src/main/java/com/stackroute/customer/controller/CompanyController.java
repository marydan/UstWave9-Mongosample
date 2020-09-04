package com.stackroute.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.customer.model.Company;
import com.stackroute.customer.model.Item;
import com.stackroute.customer.service.CompanyService;
import com.stackroute.customer.service.CustomerService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	
	@Autowired
	CompanyService companyservice;
	
	
	@PostMapping("/addCompany")
	public ResponseEntity<?> addCompanydetails(@RequestBody Company companynew)
	{
	Company companyresult=	companyservice.addCompanyDetails(companynew);
	
	return new ResponseEntity<Company>(companyresult,HttpStatus.OK);
		
	}
	
	@GetMapping("/showCompanies")
	public ResponseEntity<?> showCompany()
	{
	List<Company> companies = companyservice.viewallCompany();
	return new ResponseEntity<List>(companies,HttpStatus.OK);
	
	}
	
	@DeleteMapping("/removeCompany/{companyid}")
	public ResponseEntity<?> deleteCompanydetails(@PathVariable("companyid") String companyid)
	{
		companyservice.deleteCompany(companyid);
		
		return new ResponseEntity<String>("Company deleted",HttpStatus.OK);
	}
	
	@DeleteMapping("/removeItem/{companyid}/{itemname}")
	public ResponseEntity<?> deleteCompanyItem(@PathVariable("companyid") String cid,@PathVariable("itemname") String itmname )
	{
		companyservice.deleteCompanyItem(cid, itmname);
		return new ResponseEntity<String>("Item Deleted",HttpStatus.OK);
	}
	
  @GetMapping("/findItem/{companyid}/{itemname}")
  public ResponseEntity<?> findCompanyItem(@PathVariable("companyid") String cid,@PathVariable("itemname") String itmname )
		  {
	
	  Item itemresult=companyservice.findbyItemname(cid, itmname);
	  return new ResponseEntity<Item>(itemresult,HttpStatus.FOUND);
		  }
  
  			

}

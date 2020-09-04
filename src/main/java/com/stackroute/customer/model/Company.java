package com.stackroute.customer.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document 
public class Company {
	
	@Id
	String compnayid;
	
	String companyname;
	
	List<Item> items;

	public String getCompnayid() {
		return compnayid;
	}

	public void setCompnayid(String compnayid) {
		this.compnayid = compnayid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}

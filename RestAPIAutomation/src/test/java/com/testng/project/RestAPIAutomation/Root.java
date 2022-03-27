package com.testng.project.RestAPIAutomation;
//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

import java.util.ArrayList;

public class Root{
 public int page;
 public int per_page;
 public int getPage() {
	return page;
}
public void setPage(int page) {
	this.page = page;
}
public int getPer_page() {
	return per_page;
}
public void setPer_page(int per_page) {
	this.per_page = per_page;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public int getTotal_pages() {
	return total_pages;
}
public void setTotal_pages(int total_pages) {
	this.total_pages = total_pages;
}
public ArrayList<Datum> getData() {
	return data;
}
public void setData(ArrayList<Datum> data) {
	this.data = data;
}
public Support getSupport() {
	return support;
}
public void setSupport(Support support) {
	this.support = support;
}
public int total;
 public int total_pages;
 public ArrayList<Datum> data;
 public Support support;
}


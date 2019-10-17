package com.xerox.dbms.manageright.entity;

public class DepartmentsAvailable{
	private String Departments; 
	private int Company_ID;


	public String getDepartments(){
		return Departments;
	}

	public void setDepartments(String Departments){
		this.Departments=Departments;
	}

	public int getCompany_ID(){
		return Company_ID;
	}

	public void setCompany_ID(int Company_ID){
		this.Company_ID=Company_ID;
	}
}

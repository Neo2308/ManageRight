package com.xerox.dbms.manageright.entity;

public class Employment{
	private String WorkerType;
	private String JobTitle;
	private String Department;
	private int Employment_ID;
	private String HireDate;
	private String EndDate;
	private String StartDate;
	private int Employee_ID;

	public String getWorkerType(){
		return WorkerType;
	}

	public void setWorkerType(String WorkerType){
		this.WorkerType=WorkerType;
	}

	public String getJobTitle(){
		return JobTitle;
	}

	public void setJobTitle(String JobTitle){
		this.JobTitle=JobTitle;
	}

	public String getDepartment(){
		return Department;
	}

	public void setDepartment(String Department){
		this.Department=Department;
	}

	public int getEmployment_ID(){
		return Employment_ID;
	}

	public void setEmployment_ID(int Employment_ID){
		this.Employment_ID=Employment_ID;
	}

	public String getHireDate(){
		return HireDate;
	}

	public void setHireDate(String HireDate){
		this.HireDate=HireDate;
	}

	public String getEndDate(){
		return EndDate;
	}

	public void setEndDate(String EndDate){
		this.EndDate=EndDate;
	}

	public String getStartDate(){
		return StartDate;
	}

	public void setStartDate(String StartDate){
		this.StartDate=StartDate;
	}

	public int getEmployee_ID(){
		return Employee_ID;
	}

	public void setEmployee_ID(int Employee_ID){
		this.Employee_ID=Employee_ID;
	}
}

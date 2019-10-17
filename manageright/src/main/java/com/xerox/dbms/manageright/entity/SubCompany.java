package com.xerox.dbms.manageright.entity;

public class SubCompany
{
	private String CompanyName;
	private int Company_ID;
	private int HeadOffice;

	public String getCompanyName(){
		return CompanyName;
	}

	public void setCompanyName(String CompanyName){
		this.CompanyName=CompanyName;
	}
	
	public int getCompany_ID(){
		return Company_ID;
	}

	public void setCompany_ID(int Company_ID){
		this.Company_ID=Company_ID;
	}

	public int getHeadOffice(){
		return HeadOffice;
	}

	public void setHeadOffice(int HeadOffice){
		this.HeadOffice=HeadOffice;
	}
}

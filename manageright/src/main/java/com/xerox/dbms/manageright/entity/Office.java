package com.xerox.dbms.manageright.entity;

public class Office{
	private String Mailing_Address;
	private int Office_ID;
	private int Company;
	private int LocatedAt;

	public String getMailing_Address()
	{
		return Mailing_Address;
	}
	public void setMailing_Address(String Mailing_Address)
	{
		this.Mailing_Address=Mailing_Address;
	}
	public int getOffice_ID(){
		return Office_ID;
	}

	public void setOffice_ID(int Office_ID){
		this.Office_ID=Office_ID;
	}

	public int getCompany(){
		return Company;
	}

	public void setCompany(int Company){
		this.Company=Company;
	}

	public int getLocatedAt(){
		return LocatedAt;
	}

	public void setLocatedAt(int LocatedAt){
		this.LocatedAt=LocatedAt;
	}
}

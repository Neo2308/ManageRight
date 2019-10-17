package com.xerox.dbms.manageright.entity;

public class Employee{
	private int BaseSalary;
	private String Origin;
	private String FirstName;
	private String LastName;
	private String Nationality;
	private String DOB;
	private String Gender;
	private String MaritalStatus;
	private String HomeAddress;
	private String WorkEmail;
	private String WorkMobile;
	private String MailingAddress;
	private int Employee_ID;
	private String EduLevel;
	private long TaxIdentification;
	private int WorksFor;
	private int ManagedBy;
	private int Shift;

	public int getBaseSalary(){
		return BaseSalary;
	}

	public void setBaseSalary(int BaseSalary){
		this.BaseSalary=BaseSalary;
	}

	public String getOrigin(){
		return Origin;
	}

	public void setOrigin(String Origin){
		this.Origin=Origin;
	}

	public String getFirstName(){
		return FirstName;
	}

	public void setFirstName(String FirstName){
		this.FirstName=FirstName;
	}

	public String getLastName(){
		return LastName;
	}

	public void setLastName(String LastName){
		this.LastName=LastName;
	}

	public String getNationality(){
		return Nationality;
	}

	public void setNationality(String Nationality){
		this.Nationality=Nationality;
	}

	public String getDOB(){
		return DOB;
	}

	public void setDOB(String DOB){
		this.DOB=DOB;
	}

	public String getGender(){
		return Gender;
	}

	public void setGender(String Gender){
		this.Gender=Gender;
	}

	public String getMaritalStatus(){
		return MaritalStatus;
	}

	public void setMaritalStatus(String MaritalStatus){
		this.MaritalStatus=MaritalStatus;
	}

	public String getHomeAddress(){
		return HomeAddress;
	}

	public void setHomeAddress(String HomeAddress){
		this.HomeAddress=HomeAddress;
	}

	public String getWorkEmail(){
		return WorkEmail;
	}

	public void setWorkEmail(String WorkEmail){
		this.WorkEmail=WorkEmail;
	}

	public String getWorkMobile(){
		return WorkMobile;
	}

	public void setWorkMobile(String WorkMobile){
		this.WorkMobile=WorkMobile;
	}

	public String getMailingAddress(){
		return MailingAddress;
	}

	public void setMailingAddress(String MailingAddress){
		this.MailingAddress=MailingAddress;
	}

	public int getEmployee_ID(){
		return Employee_ID;
	}

	public void setEmployee_ID(int Employee_ID){
		this.Employee_ID=Employee_ID;
	}

	public String getEduLevel(){
		return EduLevel;
	}

	public void setEduLevel(String EduLevel){
		this.EduLevel=EduLevel;
	}

	public long getTaxIdentification(){
		return TaxIdentification;
	}

	public void setTaxIdentification(Long TaxIdentification){
		this.TaxIdentification=TaxIdentification;
	}

	public int getWorksFor(){
		return WorksFor;
	}

	public void setWorksFor(int WorksFor){
		this.WorksFor=WorksFor;
	}

	public int getManagedBy(){
		return ManagedBy;
	}

	public void setManagedBy(int ManagedBy){
		this.ManagedBy=ManagedBy;
	}

	public int getShift(){
		return Shift;
	}

	public void setShift(int Shift){
		this.Shift=Shift;
	}
}

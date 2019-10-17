package com.xerox.dbms.manageright.entity;

public class BenefitsProvided{
	private int Company_ID;
	private int Benefit_ID;

	public int getCompany_id(){
		return Company_ID;
	}

	public void setCompany_id(int Company_ID){
		this.Company_ID=Company_ID;
	}
	public int getBenefit_id(){
		return Benefit_ID;
	}

	public void setBenefit_id(int Benefit_ID){
		this.Benefit_ID=Benefit_ID;
	}
}

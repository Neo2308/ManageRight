package com.xerox.dbms.manageright.entity;

public class Compensations{
	private int Amount;
	private int Benefit_ID;
	private int Employee_ID;

	public int getAmount(){
		return Amount;
	}

	public void setAmount(int Amount){
		this.Amount=Amount;
	}

	public int getBenefit_id(){
		return Benefit_ID;
	}

	public void setBenefit_id(int Benefit_ID){
		this.Benefit_ID=Benefit_ID;
	}

	public int getEmployee_id(){
		return Employee_ID;
	}

	public void setEmployee_id(int Employee_ID){
		this.Employee_ID=Employee_ID;
	}
}

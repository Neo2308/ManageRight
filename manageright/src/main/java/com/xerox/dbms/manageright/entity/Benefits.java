package com.xerox.dbms.manageright.entity;

public class Benefits{

	private String Type;
	private String Name;
	private int Benefit_ID;

	public String getType(){
		return Type;
	}

	public void setType(String Type){
		this.Type=Type;
	}

	public String getName(){
		return Name;
	}

	public void setName(String Name){
		this.Name=Name;
	}

	public int getBenefit_ID(){
		return Benefit_ID;
	}

	public void setBenefit_ID(int Benefit_ID){
		this.Benefit_ID=Benefit_ID;
	}
}

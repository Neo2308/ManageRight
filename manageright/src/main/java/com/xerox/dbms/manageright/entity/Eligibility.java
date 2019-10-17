package com.xerox.dbms.manageright.entity;

public class Eligibility{
	private String Name;
	private int Eligibility_ID;
	private String Type;
	private String Constraints;

	public String getName(){
		return Name;
	}

	public void setName(String Name){
		this.Name=Name;
	}

	public int getEligibility_ID(){
		return Eligibility_ID;
	}

	public void setEligibility_ID(int Eligibility_ID){
		this.Eligibility_ID=Eligibility_ID;
	}

	public String getType(){
		return Type;
	}

	public void setType(String Type){
		this.Type=Type;
	}

	public String getConstraints(){
		return Constraints;
	}

	public void setConstraints(String Constraints){
		this.Constraints=Constraints;
	}
}

package com.xerox.dbms.manageright.entity;

public class AllowedLeaves{
	private int MaxAllowed;
	private int Company_ID;
	private int Leave_ID;
	private int Eligibility_ID;

	public int getMaxAllowed(){
		return MaxAllowed;
	}

	public void setMaxAllowed(int MaxAllowed){
		this.MaxAllowed=MaxAllowed;
	}

	public int getCompany_id(){
		return Company_ID;
	}

	public void setCompany_id(int Company_ID){
		this.Company_ID=Company_ID;
	}

	public int getLeave_id(){
		return Leave_ID;
	}

	public void setLeave_id(int Leave_ID){
		this.Leave_ID=Leave_ID;
	}

	public int getEligibility_id(){
		return Eligibility_ID;
	}

	public void setEligibility_id(int Eligibility_ID){
		this.Eligibility_ID=Eligibility_ID;
	}
}

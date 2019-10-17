package com.xerox.dbms.manageright.entity;

public class AllowedHolidays{
	private int Company_ID;
	private int Holiday_ID;

	public int getCompany_id(){
		return Company_ID;
	}

	public void setCompany_id(int Company_ID){
		this.Company_ID=Company_ID;
	}

	public int getHoliday_id(){
		return Holiday_ID;
	}

	public void setHoliday_id(int Holiday_ID){
		this.Holiday_ID=Holiday_ID;
	}
	
}

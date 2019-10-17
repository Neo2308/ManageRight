package com.xerox.dbms.manageright.entity;

public class CalendarHoliday{
	private int Holiday_ID;
	private String Name;
	private String EndDate;
	private String StartDate;

	public int getHoliday_ID(){
		return Holiday_ID;
	}

	public void setHoliday_ID(int Holiday_ID){
		this.Holiday_ID=Holiday_ID;
	}

	public String getName(){
		return Name;
	}

	public void setName(String Name){
		this.Name=Name;
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
}

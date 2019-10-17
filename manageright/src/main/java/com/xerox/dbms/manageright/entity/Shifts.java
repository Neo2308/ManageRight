package com.xerox.dbms.manageright.entity;

public class Shifts{
	private String Timings;
	private String Name;
	private int Shift_ID;
	private int HoursPerWeek;

	public String getTimings(){
		return Timings;
	}

	public void setTimings(String Timings){
		this.Timings=Timings;
	}

	public String getName(){
		return Name;
	}

	public void setName(String Name){
		this.Name=Name;
	}

	public int getShift_ID(){
		return Shift_ID;
	}

	public void setShift_ID(int Shift_ID){
		this.Shift_ID=Shift_ID;
	}

	public int getHoursPerWeek(){
		return HoursPerWeek;
	}

	public void setHoursPerWeek(int HoursPerWeek){
		this.HoursPerWeek=HoursPerWeek;
	}
}

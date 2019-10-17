package com.xerox.dbms.manageright.entity;

public class Leaves{
	private String Name;
	private int MaxDuration;
	private int MinDuration;
	private int Leave_ID;

	public String getName(){
		return Name;
	}

	public void setName(String Name){
		this.Name=Name;
	}

	public int getMaxDuration(){
		return MaxDuration;
	}

	public void setMaxDuration(int MaxDuration){
		this.MaxDuration=MaxDuration;
	}

	public int getMinDuration(){
		return MinDuration;
	}

	public void setMinDuration(int MinDuration){
		this.MinDuration=MinDuration;
	}

	public int getLeave_ID(){
		return Leave_ID;
	}

	public void setLeave_ID(int Leave_ID){
		this.Leave_ID=Leave_ID;
	}
}

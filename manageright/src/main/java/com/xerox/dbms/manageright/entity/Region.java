package com.xerox.dbms.manageright.entity;

public class Region{
	private String Name;
	private int Region_ID;
	private int LocatedIn;

	public String getName(){
		return Name;
	}

	public void setName(String Name){
		this.Name=Name;
	}

	public int getRegion_ID(){
		return Region_ID;
	}

	public void setRegion_ID(int Region_ID){
		this.Region_ID=Region_ID;
	}

	public int getLocatedIn(){
		return LocatedIn;
	}

	public void setLocatedIn(int LocatedIn){
		this.LocatedIn=LocatedIn;
	}
}

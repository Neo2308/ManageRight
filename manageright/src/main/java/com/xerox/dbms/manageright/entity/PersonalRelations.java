package com.xerox.dbms.manageright.entity;

public class PersonalRelations{
	private String Name;
	private int PR_ID;
	private String Mobile;
	private String Email;
	private String MailingAddress;

	public String getName(){
		return Name;
	}

	public void setName(String Name){
		this.Name=Name;
	}

	public int getPR_ID(){
		return PR_ID;
	}

	public void setPR_ID(int PR_ID){
		this.PR_ID=PR_ID;
	}

	public String getMobile(){
		return Mobile;
	}

	public void setMobile(String Mobile){
		this.Mobile=Mobile;
	}

	public String getEmail(){
		return Email;
	}

	public void setEmail(String Email){
		this.Email=Email;
	}

	public String getMailingAddress(){
		return MailingAddress;
	}

	public void setMailingAddress(String MailingAddress){
		this.MailingAddress=MailingAddress;
	}
}

package com.example.digital_socity.ApiCalling;

import com.google.gson.annotations.SerializedName;

public class Userprofile
{
	@SerializedName("HouseNo")
	private String houseNo;
	@SerializedName("ContactNo")
	private String contactNo;
	@SerializedName("Email")
	private String email;
	@SerializedName("FirstName")
	private String firstName;
	@SerializedName("Id")
	private String id;
	@SerializedName("LastName")
	private String lastName;
	@SerializedName("status")
	private String status;

	public void setHouseNo(String houseNo){
		this.houseNo = houseNo;
	}

	public String getHouseNo(){
		return houseNo;
	}

	public void setContactNo(String contactNo){
		this.contactNo = contactNo;
	}

	public String getContactNo(){
		return contactNo;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Userprofile{" + 
			"houseNo = '" + houseNo + '\'' + 
			",contactNo = '" + contactNo + '\'' + 
			",email = '" + email + '\'' + 
			",firstName = '" + firstName + '\'' + 
			",id = '" + id + '\'' + 
			",lastName = '" + lastName + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}

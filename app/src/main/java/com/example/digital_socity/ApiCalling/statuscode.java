package com.example.digital_socity.ApiCalling;

import com.google.gson.annotations.SerializedName;

public class statuscode {

	private String status;

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"status = '" + status + '\'' + 
			"}";
		}
}

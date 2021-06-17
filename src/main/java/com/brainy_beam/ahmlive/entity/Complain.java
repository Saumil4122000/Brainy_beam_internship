package com.brainy_beam.ahmlive.entity;

public class Complain {
	int id;
	int UserId;
	String Title;
	String Description;
	String address;
	String MobileNo;
	public Complain() {
		
	}
	public int getId() {
		return id;
	}

	public String getMobileNo() {
		return MobileNo;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMobileNo(String phoneNo) {
		MobileNo=phoneNo;
	}
	
}

package com.ocs.owncarservice.Dto;

import java.util.ArrayList;
import java.util.List;

import com.ocs.owncarservice.Entity.AppointmentTable;

public class UserResgistrationVO {

private String userId;
	
	private String userName;
	
	private String password;
	
	private String confirmPassword;
	
	private String emailId;
	
	private String phoneNumber;
	
	private String address;
	
	private String dateOfRegistration;
	
	private String imgUrl;

	private List<AppointmentTable> appointments = new ArrayList<>();
	
	
	
	public List<AppointmentTable> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentTable> appointments) {
		this.appointments = appointments;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}

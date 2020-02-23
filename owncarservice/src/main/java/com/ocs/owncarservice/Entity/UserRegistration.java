package com.ocs.owncarservice.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="user_registration")
public class UserRegistration implements UserDetails,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="userId")
	private String userId;
	
	@Column(name="userName")
	private String userName;
	@Column(name="userPassword")
	private String password;
	@Column(name="userConfirmPassword")
	private String confirmPassword;
	@Column(name="userEmailId")
	private String emailId;
	@Column(name="phoneNumber")
	private String phoneNumber;
	@Column(name="address")
	private String address;
	@Column(name="userDateOfRegistration")
	private String dateOfRegistration;
	@Column(name="userImgUrl")
	private String imgUrl;
	@Column(name="typeOfUser")
	private String typeOfUsers;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<AppointmentTable> appointments = new ArrayList<>();
 
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Vendor> vendor = new ArrayList<>();
	
	
	
	public List<Vendor> getVendor() {
		return vendor;
	}

	public void setVendor(List<Vendor> vendor) {
		this.vendor = vendor;
	}

	public String getTypeOfUsers() {
		return typeOfUsers;
	}

	public void setTypeOfUsers(String typeOfUsers) {
		this.typeOfUsers = typeOfUsers;
	}

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}

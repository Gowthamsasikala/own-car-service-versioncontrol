package com.ocs.owncarservice.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vendors")
public class Vendor {

	@Id
	@Column(name="vendorId")
	private String vendorId;
	@Column(name="vendorName")
	private String vendorName;
	@Column(name="vendorAddress")
	private String vendorAddress;
	@Column(name="vendorPhonenumber")
	private String vendorPhonenumber;
	@Column(name="vendorPincode")
	private String vendorPincode;
	
	private String vendorImgUrl;


	@OneToMany(mappedBy="vendor",fetch=FetchType.LAZY)
	@JsonIgnoreProperties("vendor")
	private List<AppointmentTable> appointments = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private UserRegistration user;
	
	public String getVendorImgUrl() {
		return vendorImgUrl;
	}

	public void setVendorImgUrl(String vendorImgUrl) {
		this.vendorImgUrl = vendorImgUrl;
	}
	
	

	public UserRegistration getUser() {
		return user;
	}

	public void setUser(UserRegistration user) {
		this.user = user;
	}

//	public List<AppointmentTable> getAppointments() {
//		return appointments;
//	}
//
//	public void setAppointments(List<AppointmentTable> appointments) {
//		this.appointments = appointments;
//	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorPhonenumber() {
		return vendorPhonenumber;
	}

	public void setVendorPhonenumber(String vendorPhonenumber) {
		this.vendorPhonenumber = vendorPhonenumber;
	}

	public String getVendorPincode() {
		return vendorPincode;
	}

	public void setVendorPincode(String vendorPincode) {
		this.vendorPincode = vendorPincode;
	}

	
	
	
}

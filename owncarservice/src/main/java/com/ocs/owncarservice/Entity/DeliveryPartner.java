package com.ocs.owncarservice.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="deliveryPartner")
public class DeliveryPartner {

	@Id
	@Column(name="partnerId")
	private String partnerId;
	@Column(name="partnerName")
	private String partnerName;
	@Column(name="partnerPhoneNumber")
	private String partnerPhoneNumber;
	@Column(name="partnerEmailId")
	private String partnerEmailId;
	@Column(name="partnerImgUrl")
	private String partnerImgUrl;
	@Column(name="password")
	private String password;
	@Column(name="confirmPassword")
	private String confirmPassword;
	@Column(name="rating")
	private String rating;
	
	
	@OneToMany(mappedBy="partners",fetch=FetchType.LAZY)
	@JsonIgnoreProperties("partners")
	private List<AppointmentTable> appointments = new ArrayList<>();
	
	

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<AppointmentTable> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentTable> appointments) {
		this.appointments = appointments;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public String getPartnerPhoneNumber() {
		return partnerPhoneNumber;
	}

	public void setPartnerPhoneNumber(String partnerPhoneNumber) {
		this.partnerPhoneNumber = partnerPhoneNumber;
	}

	public String getPartnerEmailId() {
		return partnerEmailId;
	}

	public void setPartnerEmailId(String partnerEmailId) {
		this.partnerEmailId = partnerEmailId;
	}

	public String getPartnerImgUrl() {
		return partnerImgUrl;
	}

	public void setPartnerImgUrl(String partnerImgUrl) {
		this.partnerImgUrl = partnerImgUrl;
	}
	
	
	
	
}

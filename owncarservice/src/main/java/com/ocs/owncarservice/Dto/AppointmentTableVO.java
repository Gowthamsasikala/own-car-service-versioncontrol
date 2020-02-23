package com.ocs.owncarservice.Dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ocs.owncarservice.Entity.DeliveryPartner;
import com.ocs.owncarservice.Entity.UserRegistration;
import com.ocs.owncarservice.Entity.Vendor;

public class AppointmentTableVO {

	private String appointmentId;
	private String pincode;
	private String vehicleType;
	private String vehicleBrand;
	private String vehicleModel;
	private String packages;
	private String address;
	private String landmark;
	private String pickUpTime;
	private String appointmentDateTime;
	private String carBikeNumberPlate;
	private String status;
	private String activeIndex;
	private String vehicle;
	
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private UserRegistration user;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Vendor vendor;
	
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private DeliveryPartner partners;
	
	
	
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getActiveIndex() {
		return activeIndex;
	}
	public void setActiveIndex(String activeIndex) {
		this.activeIndex = activeIndex;
	}
	public UserRegistration getUser() {
		return user;
	}
	public void setUser(UserRegistration user) {
		this.user = user;
	}
	public Vendor getVendor() {
		return vendor;
	}
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public DeliveryPartner getPartners() {
		return partners;
	}
	public void setPartners(DeliveryPartner partners) {
		this.partners = partners;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getPackages() {
		return packages;
	}
	public void setPackages(String packages) {
		this.packages = packages;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(String pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public String getAppointmentDateTime() {
		return appointmentDateTime;
	}
	public void setAppointmentDateTime(String appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}
	public String getCarBikeNumberPlate() {
		return carBikeNumberPlate;
	}
	public void setCarBikeNumberPlate(String carBikeNumberPlate) {
		this.carBikeNumberPlate = carBikeNumberPlate;
	}
}

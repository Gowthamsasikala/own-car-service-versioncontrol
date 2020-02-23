package com.ocs.owncarservice.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="appointment")
public class AppointmentTable {
    
	@Id
	@Column(name="appointmentId")
	private String appointmentId;
	@Column(name="pincode")
	private String pincode;
	@Column(name="vehicle")
	private String vehicle;
	@Column(name="vehicleType")
	private String vehicleType;
	@Column(name="vehicleBrand")
	private String vehicleBrand;
	@Column(name="vehicleModel")
	private String vehicleModel;
	@Column(name="packages")
	private String packages;
	@Column(name="address")
	private String address;
	@Column(name="landmark")
	private String landmark;
	@Column(name="pickUpTime")
	private String pickUpTime;
	@Column(name="appointmentDateTime")
	private String appointmentDateTime;
	@Column(name="carBikeNumberPlate")
	private String carBikeNumberPlate;
	@Column(name="status")
	private String status;
	@Column(name="activeIndex")
	private String activeIndex;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private UserRegistration user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Vendor vendor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private DeliveryPartner partners;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Package pack;
	
	
	
	public Package getPack() {
		return pack;
	}
	public void setPack(Package pack) {
		this.pack = pack;
	}
	public String getActiveIndex() {
		return activeIndex;
	}
	public void setActiveIndex(String activeIndex) {
		this.activeIndex = activeIndex;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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

package com.ocs.owncarservice.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="package")
public class Package {

	@Id
	private String packageId;
	
	private String packageName;
	
	private String packagePrice;
	
	private String packageDescription;
	
	private String typeofVehicle;
	
	@OneToMany(mappedBy="pack",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<AppointmentTable> appointments = new ArrayList<>();

	
	
	public List<AppointmentTable> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentTable> appointments) {
		this.appointments = appointments;
	}

	public String getTypeofVehicle() {
		return typeofVehicle;
	}

	public void setTypeofVehicle(String typeofVehicle) {
		this.typeofVehicle = typeofVehicle;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(String packagePrice) {
		this.packagePrice = packagePrice;
	}
	
	
	
	
	
}

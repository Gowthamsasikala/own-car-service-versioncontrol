package com.ocs.owncarservice.Service;

import java.util.List;

import com.ocs.owncarservice.Entity.AppointmentTable;
import com.ocs.owncarservice.Entity.Package;
import com.ocs.owncarservice.Entity.Vendor;

public interface VendorInterface {

	Vendor createNewVendor(Vendor newVendor);
	List<Package> getAllPackages();
	List<Vendor> getAllVendors();
	List<Vendor> getVendorsById(String userId);
	List<AppointmentTable> getVendorsByIdDate(String userId,String currentDate);
	
	
}

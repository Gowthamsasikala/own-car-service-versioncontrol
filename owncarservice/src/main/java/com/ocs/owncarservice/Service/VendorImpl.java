package com.ocs.owncarservice.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.owncarservice.Entity.AppointmentTable;
import com.ocs.owncarservice.Entity.Package;
import com.ocs.owncarservice.Entity.Vendor;
import com.ocs.owncarservice.Repo.AppointmentRepo;
import com.ocs.owncarservice.Repo.PackageRepo;
import com.ocs.owncarservice.Repo.VendorRepo;

@Service
public class VendorImpl implements VendorInterface{

	@Autowired
	VendorRepo vRepo;
	
	@Autowired
	PackageRepo pRepo;
	
	@Autowired
	AppointmentRepo aRepo;
	
	@Override
	public Vendor createNewVendor(Vendor newVendor) {
		
		Date dates = new Date();
		LocalDate localDate = dates.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year  = localDate.getYear();
		int month = localDate.getMonthValue();
		int day   = localDate.getDayOfMonth();
		String currentTime = dates.getHours()+""+dates.getMinutes()+""+dates.getSeconds();
		String AppointId = "VD"+year+""+month+""+day+""+currentTime;
		
		newVendor.setVendorId(AppointId);
		Vendor vendor = vRepo.saveAndFlush(newVendor);
		if(vendor!=null) {
			return vendor;
		}
		return null;
	}


	@Override
	public List<Package> getAllPackages() {
		List<Package> getAll = pRepo.findAll();
		return getAll;
	}


	@Override
	public List<Vendor> getAllVendors() {
		return vRepo.findAll();
	}

	@Override
	public List<Vendor> getVendorsById(String userId) {
		System.out.println(userId);
		List<Vendor> vendors  = vRepo.findByVendorUserIds(userId) ;
		System.out.println(vendors.size());
		return vendors != null ? vendors :null;
	}
	
	@Override
	public List<AppointmentTable> getVendorsByIdDate(String userId, String currentDate) {
		List<AppointmentTable> listOfOrders = aRepo.findbyappointmentdate(userId, currentDate);
		return listOfOrders!=null?listOfOrders: null;
	}
}

package com.ocs.owncarservice.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.owncarservice.Entity.AppointmentTable;
import com.ocs.owncarservice.Entity.DeliveryPartner;
import com.ocs.owncarservice.Exception.UserException;
import com.ocs.owncarservice.Repo.AppointmentRepo;
import com.ocs.owncarservice.Repo.DeliveryPartnerRepo;

@Service
public class AppointmentImpl implements AppointmentInterface {

	@Autowired
	AppointmentRepo apRepo;
	
	@Autowired
	DeliveryPartnerRepo dpRepo;
	
	@Override
	public AppointmentTable CreateAppointment(AppointmentTable appoint) {
		Date dates = new Date();
		LocalDate localDate = dates.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year  = localDate.getYear();
		int month = localDate.getMonthValue();
		int day   = localDate.getDayOfMonth();
		String currentTime = "AP"+dates.getHours()+""+dates.getMinutes()+""+dates.getSeconds();
		String AppointId = year+""+month+""+day+""+currentTime;
		appoint.setAppointmentId(AppointId);
		
		AppointmentTable appointment = apRepo.saveAndFlush(appoint);
		if(appointment != null) {
			return appointment;
		}
		return null;
	}

	@Override
	public List<AppointmentTable> getAppointments(String dates) {
		List<AppointmentTable> getAppointmentByDates = new ArrayList<>();
		List<AppointmentTable> getAllAppointments = apRepo.findAll();
		for(AppointmentTable table:getAllAppointments) {
			if(table.getAppointmentDateTime().split(" ")[0].equals(dates)) {
				getAppointmentByDates.add(table);
			}
		}
		if(getAppointmentByDates != null) {
			return getAppointmentByDates;
		}
		return null;
	}

	@Override
	public AppointmentTable updateAppointments(AppointmentTable updateAppoint) {
	    Optional<AppointmentTable> update = apRepo.findById(updateAppoint.getAppointmentId());
	    System.out.println("gow"+update.get().getAddress());
	    if(update.get() != null) {
	    	System.out.println("malini");
	    	System.out.println("hi"+update.get().getPartners().getPartnerId());
	    	Optional<DeliveryPartner> dpupdate = dpRepo.findById(update.get().getPartners().getPartnerId());
	    	update.get().setPartners(dpupdate.get());
	    	update.get().setActiveIndex(updateAppoint.getActiveIndex());
	   update.get().setStatus(updateAppoint.getStatus());
	    	AppointmentTable updateAP = apRepo.saveAndFlush(update.get());
	    return updateAP;
	    }
		return null;
	}

	@Override
	public AppointmentTable updateAppointmentsAdmin(AppointmentTable updateAppoint) {
	    Optional<AppointmentTable> update = apRepo.findById(updateAppoint.getAppointmentId());
	    System.out.println("gow"+update.get().getAddress());
	    if(update.get() != null) {
	    	
	    	Optional<DeliveryPartner> dpupdate = dpRepo.findById(updateAppoint.getPartners().getPartnerId());
	    	update.get().setPartners(dpupdate.get());
//	    	update.get().setActiveIndex(updateAppoint.getActiveIndex());
	    	AppointmentTable updateAP = apRepo.saveAndFlush(update.get());
	    return updateAP;
	    }
		return null;
	}
	
	@Override
	public List<AppointmentTable> getAllAppointments(String userId) {
		return apRepo.findByUserId(userId)!= null ?apRepo.findByUserId(userId):null ;
	}

}

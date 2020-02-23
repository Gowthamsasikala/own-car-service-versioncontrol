package com.ocs.owncarservice.Service;

import java.util.List;

import com.ocs.owncarservice.Entity.AppointmentTable;

public interface AppointmentInterface {

	AppointmentTable CreateAppointment(AppointmentTable appoint);
	List<AppointmentTable> getAppointments(String dates);
	List<AppointmentTable> getAllAppointments(String dates);
	AppointmentTable updateAppointments(AppointmentTable updateAppoint);
	AppointmentTable updateAppointmentsAdmin(AppointmentTable updateAppoint);
}

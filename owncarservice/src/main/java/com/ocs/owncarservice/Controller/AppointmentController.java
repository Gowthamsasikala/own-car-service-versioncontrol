package com.ocs.owncarservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocs.owncarservice.Entity.AppointmentTable;
import com.ocs.owncarservice.ResponseMessage.ResponseMessage;
import com.ocs.owncarservice.Service.AppointmentImpl;

@RestController
@RequestMapping(value="/Appointment")
@CrossOrigin("*")
public class AppointmentController {

	@Autowired
	AppointmentImpl apService;
	
//	user
	@PostMapping(value="/CreateAppointment")
	public ResponseEntity<?> CreateAppointment(@RequestBody AppointmentTable appoint){
		try {
			AppointmentTable table = apService.CreateAppointment(appoint);
			return new ResponseEntity<AppointmentTable>(table,HttpStatus.OK);
		}catch(Exception e) {
			ResponseMessage exceptions = new ResponseMessage();
			exceptions.setStatus("Failed");
			exceptions.setResponseMsg(e.getMessage());
			return new ResponseEntity<ResponseMessage>(exceptions,HttpStatus.BAD_GATEWAY);
		}
	}
	
//	admin 
	@GetMapping(value="/GetAppointmentsByDates/{Dates}")
	public ResponseEntity<?> getAppointments(@PathVariable("Dates") String Dates){
		ResponseMessage response = new ResponseMessage();
		try {
			if(Dates!=null) {
				
				return new ResponseEntity<List<AppointmentTable>>(apService.getAppointments(Dates),HttpStatus.OK);
			}
		}catch(Exception e) {
		
		response.setStatus("Error");
		response.setResponseMsg(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping(value="/GetAppointmentsByUserId/{userId}")
	public ResponseEntity<?> getAllAppointments(@PathVariable("userId") String userId){
		ResponseMessage response = new ResponseMessage();
		try {
			if(userId!=null) {
				
				return new ResponseEntity<List<AppointmentTable>>(apService.getAllAppointments(userId),HttpStatus.OK);
			}
		}catch(Exception e) {
		
		response.setStatus("Error");
		response.setResponseMsg(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
		
	}
	
//	@GetMapping(value="/GetPackages")
//	public ResponseEntity<?> getAllPackages(@PathVariable("userId") String userId){
//		ResponseMessage response = new ResponseMessage();
//		try {
//			if(userId!=null) {
//				
//				return new ResponseEntity<List<AppointmentTable>>(apService.getAllAppointments(userId),HttpStatus.OK);
//			}
//		}catch(Exception e) {
//		
//		response.setStatus("Error");
//		response.setResponseMsg(e.getMessage());
//		}
//		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
//		
//	}
	
//	admin
	@PutMapping(value="/updateAppointments")
	public ResponseEntity<?> updatesAppointments(@RequestBody AppointmentTable tables){
		ResponseMessage response = new ResponseMessage();
		try {
			
			if(tables!=null) {
				
				return new ResponseEntity<AppointmentTable>(apService.updateAppointments(tables),HttpStatus.OK);
			}else {
				System.out.println("null");
			}
		}catch(Exception e) {
		
		response.setStatus("Error");
		response.setResponseMsg(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	@PutMapping(value="/updateAppointmentsByAdmin")
	public ResponseEntity<?> updatesAppointmentsByAdmin(@RequestBody AppointmentTable tables){
		ResponseMessage response = new ResponseMessage();
		try {
			
			if(tables!=null) {
				
				return new ResponseEntity<AppointmentTable>(apService.updateAppointmentsAdmin(tables),HttpStatus.OK);
			}else {
				System.out.println("null");
			}
		}catch(Exception e) {
		
		response.setStatus("Error");
		response.setResponseMsg(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	
}

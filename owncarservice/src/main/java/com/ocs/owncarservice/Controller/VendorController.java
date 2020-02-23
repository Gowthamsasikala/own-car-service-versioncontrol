package com.ocs.owncarservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocs.owncarservice.Entity.AppointmentTable;
import com.ocs.owncarservice.Entity.Vendor;
import com.ocs.owncarservice.ResponseMessage.ResponseMessage;
import com.ocs.owncarservice.Service.VendorImpl;

@RestController
@RequestMapping(value="/Vendor")
public class VendorController {

	@Autowired
	VendorImpl vService;

	
	@PostMapping(value="/CreateVendor")
	public ResponseEntity<?> CreateAppointment(@RequestBody Vendor appoint){
		try {
			Vendor vendor = vService.createNewVendor(appoint);
			return new ResponseEntity<Vendor>(vendor,HttpStatus.OK);
		}catch(Exception e) {
			ResponseMessage exceptions = new ResponseMessage();
			exceptions.setStatus("Failed");
			exceptions.setResponseMsg(e.getMessage());
			return new ResponseEntity<ResponseMessage>(exceptions,HttpStatus.BAD_GATEWAY);
		}
	}
	
	@GetMapping(value="/GetAllPackages")
	public ResponseEntity<?> getAllPackage(){
		ResponseMessage response = new ResponseMessage();
		try {
				return new ResponseEntity<List<com.ocs.owncarservice.Entity.Package>>(vService.getAllPackages(),HttpStatus.OK);
			}
		catch(Exception e) {
		response.setStatus("Error");
		response.setResponseMsg(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
		
	}

	@GetMapping(value="/GetVendorsByUserId/{UserId}")
	public ResponseEntity<?> getAllVendorsByUserId(@PathVariable("UserId") String UserId){
		ResponseMessage response = new ResponseMessage();
		try {
			if(UserId!=null) {
				System.out.println(UserId);
				return new ResponseEntity<List<Vendor>>(vService.getVendorsById(UserId),HttpStatus.OK);
			}
		}catch(Exception e) {
		
		response.setStatus("Error");
		response.setResponseMsg(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@GetMapping(value="/GetVendorsByUserIdDate/{UserId}/{currentDate}")
	public ResponseEntity<?> getAllVendorsByUserId(@PathVariable("UserId") String UserId,@PathVariable("currentDate") String currentDate){
		ResponseMessage response = new ResponseMessage();
		try {
			if(UserId!=null && currentDate!= null) {
				
				return new ResponseEntity<List<AppointmentTable>>(vService.getVendorsByIdDate(UserId,currentDate),HttpStatus.OK);
			}
			
		}catch(Exception e) {
		
		response.setStatus("Error");
		response.setResponseMsg(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping(value="/GetAllVendor")
	public ResponseEntity<?> getAllVendor(){
		ResponseMessage response = new ResponseMessage();
		try {
				return new ResponseEntity<List<Vendor>>(vService.getAllVendors(),HttpStatus.OK);
			}
		catch(Exception e) {
		response.setStatus("Error");
		response.setResponseMsg(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
}

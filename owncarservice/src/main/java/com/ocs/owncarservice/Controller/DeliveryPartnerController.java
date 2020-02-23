package com.ocs.owncarservice.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocs.owncarservice.Dto.AppointmentTableVO;
import com.ocs.owncarservice.Entity.DeliveryPartner;
import com.ocs.owncarservice.ResponseMessage.ResponseMessage;
import com.ocs.owncarservice.Service.DeliveryPartnerImpl;

@RestController
@RequestMapping(value="/DeliveryPartner")
@CrossOrigin("*")
public class DeliveryPartnerController {

	
	@Autowired
	DeliveryPartnerImpl dpService;
	
	@Autowired
	private com.ocs.owncarservice.Config.JwtTokenProvider jwtTokenProvider;
	
	
	@PostMapping(value="/CreateAccount")
	public ResponseEntity<?> DeliveryPartnerAccount(@RequestBody DeliveryPartner dpbody){
		ResponseMessage res = new  ResponseMessage();
		try {
			if(dpbody != null) {
				res = dpService.CreateDPAccount(dpbody);
			}
			return new ResponseEntity<ResponseMessage>(res,HttpStatus.OK);
		}catch(Exception e) {
			res.setStatus("Error");
			res.setResponseMsg(e.getMessage());
			return new ResponseEntity<ResponseMessage>(res,HttpStatus.OK);
		}
		
	}
	
	
	@PostMapping(value="/Authentication")
	public ResponseEntity<ResponseMessage> loginUser(@RequestBody Map<String, String> loginCredential){
		try {
			
			ResponseMessage loginUser = new ResponseMessage();
			System.out.println(loginCredential.get("EmailId"));
			if(loginCredential != null) {
                           loginUser = dpService.DPAuthentication(loginCredential);
			}
			return ResponseEntity.ok().body(loginUser);
		
		}catch(Exception e) {
			ResponseMessage exceptions = new ResponseMessage();
			exceptions.setStatus("Failed");
			exceptions.setResponseMsg(e.getMessage());
			return ResponseEntity.ok().body(exceptions);

			
		
		}
	}
	
	@GetMapping(value="/GetAppointmentsByPartnerIdDate/{PartnerId}/{dates}")
	public ResponseEntity<?> getAppointments(@PathVariable("PartnerId") String PartnerId,@PathVariable("dates") String dates){
		ResponseMessage response = new ResponseMessage();
		try {
			if(PartnerId!=null && dates!=null) {
				System.out.println(PartnerId);
				return new ResponseEntity<List<AppointmentTableVO>>(dpService.getAppointmentByPartnerId(PartnerId,dates),HttpStatus.OK);
			}
		}catch(Exception e) {
		
		response.setStatus("Error");
		response.setResponseMsg(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping(value="/GetAllPartners")
	public ResponseEntity<?> getAllDp(){
		ResponseMessage response = new ResponseMessage();
		try {
			return new ResponseEntity<List<DeliveryPartner>>(dpService.getAllDPs(),HttpStatus.OK);
			
		}catch(Exception e) {
			response.setStatus("Error");
			response.setResponseMsg(e.getMessage());
		}
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
	}
	
	
}

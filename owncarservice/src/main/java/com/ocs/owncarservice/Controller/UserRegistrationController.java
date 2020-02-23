package com.ocs.owncarservice.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.ocs.owncarservice.Dto.AppointmentTableVO;
import com.ocs.owncarservice.Entity.UserRegistration;
import com.ocs.owncarservice.Repo.UserRegistrationRepo;
import com.ocs.owncarservice.ResponseMessage.ResponseMessage;
import com.ocs.owncarservice.Service.S3Service;
import com.ocs.owncarservice.Service.UserRegistrationImpl;

@RestController()
@RequestMapping(value="/UserRegistration")
@CrossOrigin("*")
public class UserRegistrationController {
	
    @Autowired
    UserRegistrationImpl userService;
		
    @Autowired
    public JavaMailSender javamailsender;
    
    @Autowired
	private S3Service s3service;
    

	@Autowired
	private com.ocs.owncarservice.Config.JwtTokenProvider jwtTokenProvider;
	
	
	@GetMapping(value="/test")
	public ResponseEntity<?> testing(){
		
		return new ResponseEntity<String>("Hi Gowtham..!",HttpStatus.BAD_REQUEST);
		
	}
    
		@PostMapping(value="/CreateAccount")
		public ResponseEntity<?> createAccount(@RequestBody UserRegistration users){
			try {
				
				ResponseMessage resp = new ResponseMessage();
				if(users!= null) {
					String user = userService.findByUserEmailId(users.getEmailId());
					//System.out.println(user+"***");
					if(user == null) {
						ResponseMessage response = userService.createAccount(users);
						if(response!=null) {
							this.SendMail(users.getEmailId(), "Successfully Registered...");
							return new ResponseEntity<ResponseMessage>(response,HttpStatus.OK);
						}
					}else {
						resp.setStatus("Failed");
						resp.setResponseMsg("Email Id already Exist..");
						return new ResponseEntity<ResponseMessage>(resp,HttpStatus.OK);
					}
					
					
				}else {
					System.out.println("null");
				}
			}catch(Exception e) {
				    return new ResponseEntity<String>("Sry this is the msg i got "+e.getMessage(),HttpStatus.OK);
			}
			return null;
		}
		
		@SuppressWarnings("unused")
		@PostMapping(value="/Authentication")
		public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginCredential){
			try {
				ResponseMessage loginUser = new ResponseMessage();
				System.out.println(loginCredential.get("EmailId"));
				 HttpHeaders header = new HttpHeaders();
				if(loginCredential != null) {
					
					   UserRegistration user = userService.findByUserEmailIds(loginCredential.get("EmailId"));
					   System.out.println(user.getAddress());
					   if(user!=null) {
						   String token = jwtTokenProvider.createToken(user.getUsername());
						     header.set("Token", token);
						 loginUser = userService.login(loginCredential);
//						  return ResponseEntity.ok().headers(header).body(loginUser);
					   }else{	   
						   loginUser.setStatus("Failure");
						   loginUser.setResponseMsg("EmailId or Password is wrong ...");
//						   return ResponseEntity.ok().headers(header).body(loginUser);
					   }
					 
				}
				  return ResponseEntity.ok().headers(header).body(loginUser);
				
			}catch(Exception e) {
				ResponseMessage exceptions = new ResponseMessage();
				exceptions.setStatus("Failure");
				exceptions.setResponseMsg("Empty");
				return ResponseEntity.ok().body(exceptions);
				
			}
			
		}
		
		@PutMapping(value="/updateAccount")
		public ResponseEntity<?> updateAccount(@RequestBody UserRegistration users){
			try {
				if(users!= null) {
					UserRegistration response = userService.updateAccount(users);
					if(response!=null) {
						//this.SendMail(users.getEmailId(), "Successfully Registered...");
						return new ResponseEntity<UserRegistration>(response,HttpStatus.OK);
					}
					
				}else {
					System.out.println("null");
				}
			}catch(Exception e) {
				    return new ResponseEntity<String>("Sry this is the msg i got "+e.getMessage(),HttpStatus.OK);
			}
			return null;
		}
		
		@GetMapping(value="/GetByUserId/{UserId}")
		public ResponseEntity<?> getUser(@PathVariable("UserId") String UserId){
			ResponseMessage response = new ResponseMessage();
			try {
				if(UserId!=null) {
					
					return new ResponseEntity<UserRegistration>(userService.getByUserId(UserId),HttpStatus.OK);
				}
			}catch(Exception e) {
			
			response.setStatus("Error");
			response.setResponseMsg(e.getMessage());
			}
			return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		@GetMapping(value="/GetAppointmentsByUserId/{UserId}")
		public ResponseEntity<?> getAppointments(@PathVariable("UserId") String UserId){
			ResponseMessage response = new ResponseMessage();
			try {
				if(UserId!=null) {
					
					return new ResponseEntity<List<AppointmentTableVO>>(userService.getAppointmentByUserId(UserId),HttpStatus.OK);
				}
			}catch(Exception e) {
			
			response.setStatus("Error");
			response.setResponseMsg(e.getMessage());
			}
			return new ResponseEntity<ResponseMessage>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		 @PostMapping("/api/file/upload")
		    public ResponseEntity<ResponseMessage> uploadUserPhotoMultipartFile(@RequestParam("keyname") String keyName, @RequestParam("uploadfile") MultipartFile file) {
		    	try {
		    	s3service.uploadFile(keyName, file);
		    	ResponseMessage r = new ResponseMessage();
		    	r.setStatus("Success");
		    	r.setResponseMsg("https://owncarservicw.s3.ap-south-1.amazonaws.com/"+keyName);
		        return new ResponseEntity<ResponseMessage>(r,HttpStatus.OK);
		    }catch(Exception e) {
		    	ResponseMessage re =new ResponseMessage();
				re.setStatus("Failed");
				re.setResponseMsg(e.getMessage());
				return new ResponseEntity<ResponseMessage>(re,HttpStatus.OK);
		    }
		    } 
		
		
		public void SendMail(String To,String content) {
			SimpleMailMessage simple = new SimpleMailMessage();
			simple.setTo(To);
			simple.setSubject("Own Car Service - User Registration");
			simple.setText(content);
			javamailsender.send(simple);
		}

}

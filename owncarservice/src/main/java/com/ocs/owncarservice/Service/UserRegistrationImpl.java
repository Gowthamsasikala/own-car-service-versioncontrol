package com.ocs.owncarservice.Service;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.owncarservice.Dto.AppointmentTableVO;
import com.ocs.owncarservice.Entity.AppointmentTable;
import com.ocs.owncarservice.Entity.UserRegistration;
import com.ocs.owncarservice.Repo.AppointmentRepo;
import com.ocs.owncarservice.Repo.UserRegistrationRepo;
import com.ocs.owncarservice.ResponseMessage.ResponseMessage;

@Service
public class UserRegistrationImpl implements UserRegistrationInterface{

	
	@Autowired
	UserRegistrationRepo userRepo;
	
	@Autowired
	AppointmentRepo apRepo;
	
	@Override
	public ResponseMessage createAccount(UserRegistration users) {
		
		ResponseMessage response = new ResponseMessage();
		
		Date dates = new Date();
		LocalDate localDate = dates.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year  = localDate.getYear();
		int month = localDate.getMonthValue();
		int day   = localDate.getDayOfMonth();
		String currentTime = dates.getHours()+""+dates.getMinutes()+""+dates.getSeconds();
		String userId = year+""+month+""+day+""+currentTime;
	    System.out.println(currentTime);
	    users.setUserId(userId);
		UserRegistration userAccount = userRepo.saveAndFlush(users);
		if(userAccount != null) {
			response.setStatus("Succeed");
			response.setResponseMsg("Successfully created..");
		}else {
			response.setStatus("Failure");
			response.setResponseMsg("Account was not created ...");
		}
		return response;
	}

	@Override
	public ResponseMessage login(Map<String, String> login) {
	ResponseMessage response = new ResponseMessage();
		
		UserRegistration userAccount = userRepo.findByNamePassword(login.get("EmailId"),login.get("password"));
		System.out.println(login.get("EmailId"));
		if(userAccount != null) {
			response.setStatus("Succeed");
			response.setResponseMsg("Successfully Logged In..");
			response.setUsers(userAccount);
		}else {
			response.setStatus("Failure");
			response.setResponseMsg("EmailId or Password is wrong ...");
		}
		return response;
	}

	
	
	
	@Override
	public List<AppointmentTableVO> getAppointmentByUserId(String UserId) {
		List<AppointmentTable> getAllAp = apRepo.findByUserId(UserId);
		List<AppointmentTableVO> getAllApVo = new ArrayList<>();
		
		for(AppointmentTable tables : getAllAp) {
			AppointmentTableVO apvo = new AppointmentTableVO();
			BeanUtils.copyProperties(tables, apvo);	
			System.out.println(tables.getUser().getAddress());

			apvo.getUser().setUserId(tables.getUser().getUserId());			
			apvo.getUser().setAddress(tables.getUser().getAddress());
			apvo.getUser().setUserName(tables.getUser().getUserName());
			apvo.getUser().setEmailId(tables.getUser().getEmailId());
			apvo.getUser().setPhoneNumber(tables.getUser().getPhoneNumber());
			apvo.getUser().setDateOfRegistration(tables.getUser().getDateOfRegistration());
			apvo.getUser().setImgUrl(tables.getUser().getImgUrl());
			apvo.getUser().setTypeOfUsers(tables.getUser().getTypeOfUsers());
			apvo.getUser().setPassword(null);
			apvo.getUser().setConfirmPassword(null);
			apvo.getPartners().setPartnerImgUrl(tables.getPartners().getPartnerImgUrl());
			apvo.getPartners().setPassword(null);
			apvo.getPartners().setAppointments(null);
			//apvo.getVendor().setAppointments(null);
			
			getAllApVo.add(apvo);
		}
		
		if(getAllApVo!=null) {
			return getAllApVo;
		}
		return null;
	}

	@Override
	public UserRegistration updateAccount(UserRegistration user) {
		Optional<UserRegistration> userUpdate = userRepo.findById(user.getUserId());
		if(userUpdate!=null) {
			return userRepo.saveAndFlush(user);
		}
		return null;
	}

	@Override
	public UserRegistration getByUserId(String userId) {
		// TODO Auto-generated method stub
		Optional<UserRegistration> user = userRepo.findById(userId);
		return user.get();
	}

	@Override
	public String findByUserEmailId(String email) {
		String val;
		UserRegistration users = userRepo.findByEmailIds(email);
		if(users == null) {
			val = null;
		}else {
			val =  "notNull";
		}
		return val;
	}
	
	@Override
	public UserRegistration findByUserEmailIds(String email) {
		// TODO Auto-generated method stub
		System.out.println("login");
		UserRegistration users = userRepo.findByEmailIds(email);
		//System.out.println(users);
		//System.out.println(users.getAddress()+"-----");
		//System.out.println(users.getAddress());
		return users == null ? null : users ;
	}
}

package com.ocs.owncarservice.Service;


import java.util.List;
import java.util.Map;

import com.ocs.owncarservice.Dto.AppointmentTableVO;
import com.ocs.owncarservice.Entity.UserRegistration;
import com.ocs.owncarservice.ResponseMessage.ResponseMessage;

public interface UserRegistrationInterface {

	ResponseMessage createAccount(UserRegistration users); 
	ResponseMessage login(Map<String, String> login);
	List<AppointmentTableVO> getAppointmentByUserId(String UserId);
	UserRegistration updateAccount(UserRegistration user);
	UserRegistration getByUserId(String userId);
	String findByUserEmailId(String email);
	UserRegistration findByUserEmailIds(String email);
}

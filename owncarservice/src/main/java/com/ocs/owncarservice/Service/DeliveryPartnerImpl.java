package com.ocs.owncarservice.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.owncarservice.Dto.AppointmentTableVO;
import com.ocs.owncarservice.Dto.DeliveryPartnerVO;
import com.ocs.owncarservice.Entity.AppointmentTable;
import com.ocs.owncarservice.Entity.DeliveryPartner;
import com.ocs.owncarservice.Repo.AppointmentRepo;
import com.ocs.owncarservice.Repo.DeliveryPartnerRepo;
import com.ocs.owncarservice.ResponseMessage.ResponseMessage;

@Service
public class DeliveryPartnerImpl implements DeliveryPartnerInterface{

	@Autowired
	DeliveryPartnerRepo dpRepo;
	
	@Autowired
	AppointmentRepo apRepo;
	
	@Override
	public ResponseMessage CreateDPAccount(DeliveryPartner DPaccount) {
		ResponseMessage response = new ResponseMessage();
		Date dates = new Date();
		LocalDate localDate = dates.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int year  = localDate.getYear();
		int month = localDate.getMonthValue();
		int day   = localDate.getDayOfMonth();
		String currentTime = "DP"+dates.getHours()+""+dates.getMinutes()+""+dates.getSeconds();
		String userId = year+""+month+""+day+""+currentTime;
		DPaccount.setPartnerId(userId);
		DeliveryPartner dp = dpRepo.saveAndFlush(DPaccount);
		if(dp!=null) {
			response.setStatus("Success");
			response.setResponseMsg("Successfully Saved..");
		}else {
			response.setStatus("Failed");
			response.setResponseMsg("Failed not created successfully...");
		}
		return response;
		
	}

	@Override
	public ResponseMessage DPAuthentication(Map<String, String> dplogin) {
	   DeliveryPartner dp = dpRepo.findByDPNamePassword(dplogin.get("EmailId"), dplogin.get("password"));
	   ResponseMessage resposne = new ResponseMessage();
	   if(dp!=null) {
		   resposne.setStatus("Succeed");
		   resposne.setResponseMsg("Logged In Successfully..");
		  resposne.setDpUser(dp);
	   }else {
		   resposne.setStatus("Failed");
		   resposne.setResponseMsg("Failed to Logged In..");
	   }
	   return resposne;
	}

	@Override
	public List<AppointmentTableVO> getAppointmentByPartnerId(String UserId,String dates) {
		List<AppointmentTable> getAllAp = apRepo.findByPartnerIds(UserId,dates);
		System.out.println(getAllAp.size());
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
	public List<DeliveryPartner> getAllDPs() {
		List<DeliveryPartner> listOfDp = dpRepo.findAll();
		return listOfDp!=null?listOfDp : null;
	}

	@Override
	public DeliveryPartner findByEmailIds(String EmailID) {
		DeliveryPartner dps = dpRepo.findByEmailIds(EmailID);
		return dps;
	}

}

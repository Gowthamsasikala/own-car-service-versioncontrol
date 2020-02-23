package com.ocs.owncarservice.Service;

import java.util.List;
import java.util.Map;

import com.ocs.owncarservice.Dto.AppointmentTableVO;
import com.ocs.owncarservice.Entity.DeliveryPartner;
import com.ocs.owncarservice.ResponseMessage.ResponseMessage;

public interface DeliveryPartnerInterface {

	ResponseMessage CreateDPAccount(DeliveryPartner DPaccount);
	ResponseMessage DPAuthentication(Map<String,String> dplogin);
	List<AppointmentTableVO> getAppointmentByPartnerId(String UserId,String dates);
	List<DeliveryPartner> getAllDPs();
	DeliveryPartner findByEmailIds(String EmailID);
}

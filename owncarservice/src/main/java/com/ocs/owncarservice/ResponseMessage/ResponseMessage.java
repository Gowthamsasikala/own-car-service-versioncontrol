package com.ocs.owncarservice.ResponseMessage;

import com.ocs.owncarservice.Entity.DeliveryPartner;
import com.ocs.owncarservice.Entity.UserRegistration;

public class ResponseMessage {

	
	private String status;
	private String responseMsg;
	private UserRegistration users;
	private DeliveryPartner dpUser;
	
	
	
	
	public DeliveryPartner getDpUser() {
		return dpUser;
	}
	public void setDpUser(DeliveryPartner dpUser) {
		this.dpUser = dpUser;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public UserRegistration getUsers() {
		return users;
	}
	public void setUsers(UserRegistration users) {
		this.users = users;
	}
	
}

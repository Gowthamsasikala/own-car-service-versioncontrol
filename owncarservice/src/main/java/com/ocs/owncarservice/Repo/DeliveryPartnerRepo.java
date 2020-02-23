package com.ocs.owncarservice.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ocs.owncarservice.Entity.DeliveryPartner;
import com.ocs.owncarservice.Entity.UserRegistration;

@Repository
public interface DeliveryPartnerRepo extends JpaRepository<DeliveryPartner, String> {

	@Query("Select s from DeliveryPartner s where s.partnerEmailId = :userName and s.password = :password")
	DeliveryPartner findByDPNamePassword(@Param("userName") String userName, @Param("password") String password);
	
	
	@Query("SELECT us FROM DeliveryPartner us WHERE us.partnerEmailId = :emailId")
	DeliveryPartner findByEmailIds(@Param("emailId") String emailId);
}

package com.ocs.owncarservice.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ocs.owncarservice.Entity.AppointmentTable;
import com.ocs.owncarservice.Entity.DeliveryPartner;
@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentTable, String> {

	@Query("Select a from AppointmentTable a where a.vendor.vendorId = :vendorId and a.appointmentDateTime = :currentDate")
	List<AppointmentTable> findbyappointmentdate(@Param("vendorId") String vendorId,@Param("currentDate") String currentDate);
	
	
	@Query("Select u from AppointmentTable u where u.user.userId = :userId")
	List<AppointmentTable> findByUserId(@Param("userId") String userId);
	
	@Query("Select u from AppointmentTable u where u.partners.partnerId = :userId and u.appointmentDateTime = :dates")
	List<AppointmentTable> findByPartnerIds(@Param("userId") String userId,@Param("dates") String dates);
}

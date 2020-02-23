package com.ocs.owncarservice.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ocs.owncarservice.Entity.AppointmentTable;
import com.ocs.owncarservice.Entity.Vendor;
@Repository
public interface VendorRepo extends JpaRepository<Vendor, String> {


	@Query("Select u from Vendor u where u.user.userId = :userId")
List<Vendor> findByVendorUserIds(@Param("userId") String userId);
	
}

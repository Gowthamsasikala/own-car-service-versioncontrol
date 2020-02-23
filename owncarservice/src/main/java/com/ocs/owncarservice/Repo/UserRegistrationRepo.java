package com.ocs.owncarservice.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.ocs.owncarservice.Entity.UserRegistration;

@Repository
public interface UserRegistrationRepo extends JpaRepository<UserRegistration, String>{

	

	@Query("Select s from UserRegistration s where s.emailId = :userName and s.password = :password")
	UserRegistration findByNamePassword(@Param("userName") String userName, @Param("password") String password);
	
	@Query("SELECT us FROM UserRegistration us WHERE us.userName = :userName")
	UserRegistration findByUserName(@Param("userName") String userName);
	
	@Query("SELECT us FROM UserRegistration us WHERE us.emailId = :emailId")
	UserRegistration findByEmailIds(@Param("emailId") String emailId);
}

package com.ocs.owncarservice.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.ocs.owncarservice.Repo.UserRegistrationRepo;


@Component
public class CustomUserDetailService implements UserDetailsService{

	 @Autowired
	 private UserRegistrationRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
			return repo.findByUserName(username);	
		}catch(UsernameNotFoundException e) {
			throw new UsernameNotFoundException("User Not found");
		}
		
	}

}

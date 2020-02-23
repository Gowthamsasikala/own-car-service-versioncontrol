package com.ocs.owncarservice.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().disable()
		    .csrf().disable()
		    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		    .and()
		    .authorizeRequests()
		    .antMatchers("/UserRegistration/CreateAccount").permitAll()
		    .antMatchers("/UserRegistration/test").permitAll()
		    .antMatchers("/UserRegistration/Authentication").permitAll()
		    .antMatchers("/DeliveryPartner/CreateAccount").permitAll()
		    .antMatchers("/DeliveryPartner/Authentication").permitAll()
		    .antMatchers("/DeliveryPartner/GetAllPartners").permitAll()
		    .antMatchers("/Appointment/updateAppointments").permitAll()
		    .antMatchers("/UserRegistration/api/file/upload").permitAll()
		    .antMatchers("/DeliveryPartner/GetAppointmentsByPartnerIdDate/**/**/").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/UserRegistration/updateAccount").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/UserRegistration/GetByUserId/**/").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/UserRegistration/GetAppointmentsByUserId/*/").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/UserRegistration/api/file/upload").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/Vendor/GetAllPackages").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/Vendor/GetVendorsByUserId/**/").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/Vendor/GetVendorsByUserIdDate/**/**/").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/Vendor/GetAllVendor").permitAll()
		    
		    .antMatchers(HttpMethod.OPTIONS, "/Appointment/CreateAppointment").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/Vendor/CreateVendor").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/Appointment/GetAppointmentsByDates/**/").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/Appointment/GetAppointmentsByUserId/**/").permitAll()
		   // .antMatchers(HttpMethod.OPTIONS, "/Appointment/updateAppointments").permitAll()
		    .antMatchers(HttpMethod.OPTIONS, "/Appointment/updateAppointmentsByAdmin").permitAll()
		    
		  
		  
		    
		    .anyRequest().authenticated()
		    .and()
		    .apply(new JwtConfigurer(jwtTokenProvider));
		
		
	}

	
	
	
}

package com.ocs.owncarservice.Config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenProvider {
    
	
	private String SecretKey ="owncarservice" ;
	
	
	private long validityPeriod = 86400000;
	
	@Autowired
	private UserDetailsService userDetailService;
	
	public String createToken(String userName) {
		
		Date now = new Date();
	    Date validityDate = new Date(now.getTime()+validityPeriod);
        Claims claims = Jwts.claims().setSubject(userName);
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(validityDate)
				.signWith(SignatureAlgorithm.HS256, SecretKey)
				.compact();
        	}
	
	public String resolveToken(HttpServletRequest req) {
		
		String bearerToken = req.getHeader("Authorization");
		
		if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		
		return null;
	}
	
	
	public Boolean validateToken(String Token) {
	try {
		Jws<Claims> claim = Jwts.parser().setSigningKey(SecretKey).parseClaimsJws(Token);
		System.out.println(claim.getBody().getSubject());
		System.out.println(Token);
        if(claim.getBody().getExpiration().before(new Date())) {
			return false;
		}
		return true;
	   }
	 catch(JwtException e) {
		 System.out.println("sry invalid token...!");
	 }
	return false;
	}
	
	
	public String getUserName(String token) {
		Jws<Claims> claim = Jwts.parser().setSigningKey(SecretKey).parseClaimsJws(token);
		return claim.getBody().getSubject();
	}
	
	public Authentication getAuthentication(String token) {
		UserDetails userDetails = this.userDetailService.loadUserByUsername(getUserName(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}
	
	
}

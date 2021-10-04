package com.example.demo;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Demo {

	
	public static String generateToken(String secretKey)
	{
		return Jwts.builder()
				.setId("TS08HN8999")
				.setIssuer("RAJ")
				.setSubject("rajeev")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(2)))
				.signWith(SignatureAlgorithm.HS256,Base64.getEncoder().encode(secretKey.getBytes()))
				.compact();
	}
	
	public static void main(String[] args) {
	
		final String secretKey="Prudhvi@8880";
		
//		String token=generateToken(secretKey);
//		System.out.println(token);
		
		String generatedToken="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJUUzA4SE44OTk5IiwiaXNzIjoiUkFKIiwic3ViIjoicmFqZWV2IiwiaWF0IjoxNjMzMzUzNDA1LCJleHAiOjE2MzMzNTM1MjV9.kIdUXBP-cPOA9Gt4uNTc47u2CB_RJSzxhIcCmRDMeX0";
		Claims claims=Jwts.parser().setSigningKey(Base64.getEncoder().encode(secretKey.getBytes()))
		.parseClaimsJws(generatedToken).getBody();
		
		System.out.println("Token ID :"+claims.getId());
		System.out.println("Token Name :"+claims.getSubject());
		System.out.println("Token Issuer :"+claims.getIssuer());
		System.out.println("Token Issued At :"+claims.getIssuedAt());
		System.out.println("Token Expires At :"+claims.getExpiration());
		
		

	}

}

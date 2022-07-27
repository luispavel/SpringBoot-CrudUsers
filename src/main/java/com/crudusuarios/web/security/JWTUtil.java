package com.crudusuarios.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {
	//generated in https://www.allkeysgenerator.com/
	private static final String SECRET_KEY = "DWFYGZH2K4M5N7Q8R9TBUCVEXFYG2J3K4N6P7Q9SATBVDWEXFZH2J3M5N6";

	public String generateToken(UserDetails userDetails){
		return Jwts.builder()
				.setSubject(userDetails.getUsername())
				.setIssuedAt(new Date())
				//expires in 8 hours
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 8))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}

	public boolean validateToken(String token, UserDetails userDetails){
		return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
	}

	public boolean isTokenExpired(String token) {
		return getClaims(token).getExpiration().before(new Date());
	}

	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY)
				.parseClaimsJws(token).getBody();
	}

	public String extractUsername(String token) {
		return getClaims(token).getSubject();
	}
}

package org.ac.cst8277.ismail.hamdi.ums.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.ac.cst8277.ismail.hamdi.ums.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;

import javax.crypto.SecretKey;

@Service
public class JwtTokenService {

    private static final String SECRET_KEY = "4195e5768128c74f81a407caec30c07f46981949d23ef3c7a91d66cd42c994d0";
    
    private SecretKey getSigninKey() {
		byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public String generateToken(User user) {
		String token = Jwts
				.builder()
				.subject(user.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+ 15*60*1000))
				.signWith(getSigninKey())
				.compact();
		return token;
	}
}
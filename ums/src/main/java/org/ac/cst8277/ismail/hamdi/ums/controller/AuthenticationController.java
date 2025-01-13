package org.ac.cst8277.ismail.hamdi.ums.controller;

import org.ac.cst8277.ismail.hamdi.ums.model.AuthenticationResponse;
import org.ac.cst8277.ismail.hamdi.ums.model.User;
import org.ac.cst8277.ismail.hamdi.ums.repository.UserRepository;
import org.ac.cst8277.ismail.hamdi.ums.service.AuthenticationService;
import org.ac.cst8277.ismail.hamdi.ums.service.JwtTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

	private final AuthenticationService authService;
	public AuthenticationController(AuthenticationService authService, UserRepository userrepository, JwtTokenService jwtTokenService) {
		this.authService = authService;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody User request){
		return ResponseEntity.ok(authService.register(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody User request){
		return ResponseEntity.ok(authService.authenticate(request));
	}
}

package com.crudusuarios.web.controller;

import com.crudusuarios.domain.dto.AuthenticationRequest;
import com.crudusuarios.domain.dto.AuthenticationResponse;
import com.crudusuarios.domain.service.OwnUserDetailsService;
import com.crudusuarios.web.security.JWTUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private OwnUserDetailsService ownUserDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/authenticate")
	@ApiOperation("Get token user, send body username: pavel password: 12345678")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 401, message = "Unauthorized")
	})
	public ResponseEntity<AuthenticationResponse> createToken(
			@RequestBody AuthenticationRequest request) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			UserDetails userDetails = ownUserDetailsService.loadUserByUsername(request.getUsername());
			String jwt = jwtUtil.generateToken(userDetails);
			return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}

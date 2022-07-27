package com.crudusuarios.domain.dto;

public class AuthenticationResponse {
	private String jwt;

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getToken() {
		return jwt;
	}

	public void setToken(String token) {
		this.jwt = jwt;
	}
}

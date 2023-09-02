package com.example.demo.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class TokeTO extends RepresentationModel<TokeTO> implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String jwtSecret;

	private Integer jwtExpiration;

	public String getJwtSecret() {
		return jwtSecret;
	}

	public void setJwtSecret(String jwtSecret) {
		this.jwtSecret = jwtSecret;
	}

	public Integer getJwtExpiration() {
		return jwtExpiration;
	}

	public void setJwtExpiration(Integer jwtExpiration) {
		this.jwtExpiration = jwtExpiration;
	}
	
	
	
	
}

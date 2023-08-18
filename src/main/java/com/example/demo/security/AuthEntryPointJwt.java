 package com.example.demo.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger LOG = LoggerFactory.getLogger(AuthEntryPointJwt.class);
	


	@Override
	public void commence(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response,
			AuthenticationException authException) throws IOException, javax.servlet.ServletException {
		// TODO Auto-generated method stub
		LOG.error("Unauthorized error: {}", authException.getMessage());

		LOG.error(request.getServletPath());
	}

}

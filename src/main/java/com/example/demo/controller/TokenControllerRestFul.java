package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwtUtils;
import com.example.demo.service.to.TokeTO;
import com.example.demo.service.to.UsuarioTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/tokens")
@CrossOrigin
public class TokenControllerRestFul {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired

	private JwtUtils jwtUtils;

	@PostMapping("/obtener")
	public String obtenerToken(@RequestBody UsuarioTO usuarioTO) {

		this.authenticated(usuarioTO.getUsername(), usuarioTO.getPassword());
		//return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
	return this.jwtUtils.generateJwtToken(usuarioTO.getUsername()); 
	}
	
	@PostMapping("/obtenertoken/{semilla}/{tiempo}")
	public String obtenerToke2(@RequestBody UsuarioTO usuarioTO, @PathVariable String semilla,@PathVariable Integer tiempo) {

		this.authenticated(usuarioTO.getUsername(), usuarioTO.getPassword());

		
		return Jwts.builder().setSubject(usuarioTO.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + tiempo))
				.signWith(SignatureAlgorithm.HS512, semilla).compact();
		
		//return "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c3VhcmlvIiwiaWF0IjoxNjkzNjY0Njk4LCJleHAiOjE2OTM2NjY2OTh9.6N03XaCvqGm0wAnFVQd1GBeUG_Ps-i6dCLrVxrQq5Eeom-yx2BP5Vq3aaMY4A_SaYK3gIstPTFGq6FO4_L02Gg";
	}
	
	
	

	// metodo de autenticacion
	private void authenticated(String usuario, String password) {
		Authentication authentication = this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(usuario, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}

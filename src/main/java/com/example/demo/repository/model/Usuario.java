package com.example.demo.repository.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "usuario")
@Entity
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usu_id_seq")
	@SequenceGenerator(name = "usu_id_seq", sequenceName = "usu_id_seq", allocationSize = 1)
	@Column(name = "usu_id")
	private Integer id;
	@Column(name = "usu_username")

	private String username;
	@Column(name = "usu_password")

	private String password;
	
	//GET Y SET
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}

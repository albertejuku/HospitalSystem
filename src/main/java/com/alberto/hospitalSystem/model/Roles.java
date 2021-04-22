package com.alberto.hospitalSystem.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Roles {

	@Id
	@Column(name = "role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long role_id;
	
	@Column(name = "role_name")
		private String role_name;
	
	@Column(name = "role_details")
		private String role_details;
	
	@ManyToOne
		private Doctors doctor;

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_details() {
		return role_details;
	}

	public void setRole_details(String role_details) {
		this.role_details = role_details;
	}

	public Doctors getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}

		
	
	
}

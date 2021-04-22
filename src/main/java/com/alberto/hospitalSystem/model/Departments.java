package com.alberto.hospitalSystem.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Departments")
public class Departments implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "dep_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long dep_id;
	
	@Column(name = "dep_name")
		private String dep_name;
	
	@ManyToOne
		private Hospital hospital;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="dep_id")
		private Set<Doctors> doctor;

	public Long getDep_id() {
		return dep_id;
	}

	public void setDep_id(Long dep_id) {
		this.dep_id = dep_id;
	}

	public String getDep_name() {
		return dep_name;
	}

	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Set<Doctors> getDoctor() {
		return doctor;
	}

	public void setDoctor(Set<Doctors> doctor) {
		this.doctor = doctor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

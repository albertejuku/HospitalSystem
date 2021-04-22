package com.alberto.hospitalSystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Treatment")
public class Treatment implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "treat_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long treat_id;
	
	@Column(name = "treat_results")
		private String results;
	
	@Column(name = "treat_details")
		private String details;
	
	@ManyToOne
 		private Patient patient;

	public Long getTreat_id() {
		return treat_id;
	}

	public void setTreat_id(Long treat_id) {
		this.treat_id = treat_id;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

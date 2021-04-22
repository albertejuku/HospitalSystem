package com.alberto.hospitalSystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Prescription")
public class Prescription implements Serializable{


	@Id
	@Column(name = "pres_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long pres_id;
	
	@Column(name = "pres_results")
		private String results;
	
	@Column(name = "pres_details")
		private String details;
	
	@ManyToOne
 		private Patient patient;

	public Long getPres_id() {
		return pres_id;
	}

	public void setPres_id(Long pres_id) {
		this.pres_id = pres_id;
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
	
	
	
}

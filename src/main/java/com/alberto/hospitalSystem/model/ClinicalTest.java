package com.alberto.hospitalSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ClinicalTest")
public class ClinicalTest {
	
	@Id
	@Column(name = "test_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long test_id;
	
	@Column(name = "test_results")
		private String results;
	
	@Column(name = "details")
		private String details;
	
	@ManyToOne
		private Patient patient;

	public Long getTest_id() {
		return test_id;
	}

	public void setTest_id(Long test_id) {
		this.test_id = test_id;
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

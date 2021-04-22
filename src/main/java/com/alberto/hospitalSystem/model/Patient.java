package com.alberto.hospitalSystem.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Patient")
public class Patient {

	@Id
	@Column(name = "pat_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long pat_id;
	
	@Column(name = "pat_first_name")
		private String first_name;
	
	@Column(name = "pat_last_name")
		private String last_name;
	
	@Column(name = "pat_email")
		private String email;

	@Column(name = "pat_phone")
		private String phone;
	
	@Column(name="case_title")
		public String case_title;
	
	@Column(name="case_details")
		private String case_details;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pat_id")
		private Set<Cost> cost;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pat_id")
		private Set<Prescription> prescription;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pat_id")
		private Set<ClinicalTest> clinical_test;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pat_id")
		private Set<Treatment> treatment;

	public Long getPat_id() {
		return pat_id;
	}

	public void setPat_id(Long pat_id) {
		this.pat_id = pat_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Cost> getCost() {
		return cost;
	}

	public void setCost(Set<Cost> cost) {
		this.cost = cost;
	}

	public Set<Prescription> getPrescription() {
		return prescription;
	}

	public void setPrescription(Set<Prescription> prescription) {
		this.prescription = prescription;
	}

	public Set<ClinicalTest> getClinical_test() {
		return clinical_test;
	}

	public void setClinical_test(Set<ClinicalTest> clinical_test) {
		this.clinical_test = clinical_test;
	}

	public Set<Treatment> getTreatment() {
		return treatment;
	}

	public void setTreatment(Set<Treatment> treatment) {
		this.treatment = treatment;
	}

	public String getCase_title() {
		return case_title;
	}

	public void setCase_title(String case_title) {
		this.case_title = case_title;
	}

	public String getCase_details() {
		return case_details;
	}

	public void setCase_details(String case_details) {
		this.case_details = case_details;
	}

	
	
	
}
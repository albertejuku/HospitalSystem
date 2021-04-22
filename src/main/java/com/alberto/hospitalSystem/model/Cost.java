package com.alberto.hospitalSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cost")
public class Cost {
	
	@Id
	@Column(name = "cost_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long cost_id;
	
	@Column(name = "total_cost")
		private Long total_cost;
	
	@Column(name = "amount_cost")
		private Long amount_paid;
	
	@ManyToOne
		private Patient patient;

	public Long getCost_id() {
		return cost_id;
	}

	public void setCost_id(Long cost_id) {
		this.cost_id = cost_id;
	}

	public Long getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(Long total_cost) {
		this.total_cost = total_cost;
	}

	public Long getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(Long amount_paid) {
		this.amount_paid = amount_paid;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	

}

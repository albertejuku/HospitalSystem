package com.alberto.hospitalSystem.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StatusHistory")
public class StatusHistory {
	

	@Id
	@Column(name = "hist_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long hist_id;
	
	@Column(name="status_time",columnDefinition="TIMESTAMP")      
    	private LocalDateTime status_time;
	
	@Column(name = "details")
		private String details;
	
	@ManyToOne
 		private Appointments appointments;

	public Long getHist_id() {
		return hist_id;
	}

	public void setHist_id(Long hist_id) {
		this.hist_id = hist_id;
	}

	public LocalDateTime getStatus_time() {
		return status_time;
	}

	public void setStatus_time(LocalDateTime status_time) {
		this.status_time = status_time;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Appointments getAppointments() {
		return appointments;
	}

	public void setAppointments(Appointments appointments) {
		this.appointments = appointments;
	}
	
	
	
}

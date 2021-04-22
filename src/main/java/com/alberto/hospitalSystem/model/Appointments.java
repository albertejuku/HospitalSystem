package com.alberto.hospitalSystem.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
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

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Appointments")
public class Appointments implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "app_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long app_id;
	
	 @Column(name="time_created",columnDefinition="TIMESTAMP")      
	    private LocalDateTime time_created;
	
	 @Column(name="app_start_time",columnDefinition="TIME") 
	    private LocalDateTime start_time;
	 
	 @Column(name="app_date", columnDefinition="DATE")
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 	private Date date;
	 
	 @Column(name="app_end_time",columnDefinition="TIME")      
	    private LocalDateTime end_time;
	 
	 @Column(name = "app_status")
	 	private String app_status;
	 	 
	 @ManyToOne
	 	private Doctors doctor;
	 
	 @ManyToOne
	 	private Patient patient;
	 
	 

	@OneToMany(cascade=CascadeType.ALL)
	 @JoinColumn(name="app_id")
	 	private Set<StatusHistory> status_history;



	public Long getApp_id() {
		return app_id;
	}



	public void setApp_id(Long app_id) {
		this.app_id = app_id;
	}



	public LocalDateTime getTime_created() {
		return time_created;
	}



	public void setTime_created(LocalDateTime time_created) {
		this.time_created = time_created;
	}



	public LocalDateTime getStart_time() {
		return start_time;
	}



	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public LocalDateTime getEnd_time() {
		return end_time;
	}



	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}



	public String getApp_status() {
		return app_status;
	}



	public void setApp_status(String app_status) {
		this.app_status = app_status;
	}



	public Doctors getDoctor() {
		return doctor;
	}



	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public Set<StatusHistory> getStatus_history() {
		return status_history;
	}



	public void setStatus_history(Set<StatusHistory> status_history) {
		this.status_history = status_history;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	 

	 
}

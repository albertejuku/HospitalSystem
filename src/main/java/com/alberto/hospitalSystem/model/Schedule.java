package com.alberto.hospitalSystem.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Schedule")
public class Schedule {

	@Id
	@Column(name = "schedule_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long schedule_id;
	
	@Column(name="time_start",columnDefinition="TIMESTAMP")      
    private LocalDateTime start_time;
 
	 @Column(name="time_end",columnDefinition="TIMESTAMP")      
	    private LocalDateTime end_time;
	 
	 @Column(name = "schedule_date")
	 @JsonFormat(pattern="yyyy-MM-dd")
	    private LocalDate schedule_date;
	
	 @ManyToOne
	 	private Doctors doctor;

	public Long getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(Long schedule_id) {
		this.schedule_id = schedule_id;
	}

	public LocalDateTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}

	public LocalDateTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}

	public LocalDate getSchedule_date() {
		return schedule_date;
	}

	public void setSchedule_date(LocalDate schedule_date) {
		this.schedule_date = schedule_date;
	}

	public Doctors getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctors doctor) {
		this.doctor = doctor;
	}
	 
	 
	 
}

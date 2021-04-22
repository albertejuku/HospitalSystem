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
@Table(name = "Doctors")
public class Doctors implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
		private Long emp_id;
	
	@Column(name = "emp_first_name")
		private String first_name;
	
	@Column(name = "emp_last_name")
		private String last_name;
	
	@Column(name = "emp_username")
		private String username;
	
	@Column(name = "emp_email")
		private String email;
	
	@Column(name = "emp_password")
		private String password;
	
	@Column(name = "emp_phone")
		private String phone;
	
	@Column(name = "dep_id")
		private String department;
	
	@Column(name = "is_active")
		private boolean is_active;
	
	@ManyToOne
		private Departments deparment;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
		private Set<Schedule> schedule;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
		private Set<Roles> role;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
		private Set<Appointments> appointment;

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public Departments getDeparment() {
		return deparment;
	}

	public void setDeparment(Departments deparment) {
		this.deparment = deparment;
	}

	public Set<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Schedule> schedule) {
		this.schedule = schedule;
	}

	public Set<Roles> getRole() {
		return role;
	}

	public void setRole(Set<Roles> role) {
		this.role = role;
	}

	public Set<Appointments> getAppointment() {
		return appointment;
	}

	public void setAppointment(Set<Appointments> appointment) {
		this.appointment = appointment;
	}
	
	
	
}

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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Hospital")
public class Hospital implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	 @Column(name = "hosp_id")
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;

	 @Column(name = "hosp_name")
	 private String hosp_name;

	 @Column(name = "hosp_address")
	 private String hosp_address;
	 
	 @Column(name = "hosp_details")
	 private String hosp_details;
	 
	 @OneToMany(cascade=CascadeType.ALL)
	 @JoinColumn(name="hosp_id")
	 	private Set<Departments> department;
	 
	 
	 
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hosp_name=" + hosp_name + ", hosp_address=" + hosp_address + ", hosp_details="
				+ hosp_details + "]";
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getHosp_name() {
		return hosp_name;
	}
	public void setHosp_name(String hosp_name) {
		this.hosp_name = hosp_name;
	}
	
	
	public String getHosp_address() {
		return hosp_address;
	}
	public void setHosp_address(String hosp_address) {
		this.hosp_address = hosp_address;
	}
	

	public String getHosp_details() {
		return hosp_details;
	}
	public void setHosp_details(String hosp_details) {
		this.hosp_details = hosp_details;
	}

	
	public Set<Departments> getDepartment() {
		return department;
	}
	public void setDepartment(Set<Departments> department) {
		this.department = department;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 	 
	 
	    
}

package com.alberto.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Roles;
import com.alberto.hospitalSystem.repository.RoleRepo;
import com.alberto.hospitalSystem.service.DoctorService;

@Controller
public class RolesController {
	
	@Autowired
	RoleRepo repo;
	
	@Autowired
	DoctorService service;
	
	@RequestMapping("/doctor/addRole/{id}")
	public String addRole(Roles role, @PathVariable("id") Long id ) throws RecordNotFoundException {
		
		role.setDoctor(service.getDoctorById(id));
		role.setRole_name(role.getRole_details());
		role.setRole_details(role.getRole_details());
		
		repo.save(role);
		return "redirect:/doc_list/{id}";
		
	}
	
	@RequestMapping("/doctor/createRole/{id}")
	public String createRole() {
		return "role.html";
	}

}

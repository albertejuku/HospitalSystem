package com.alberto.hospitalSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alberto.hospitalSystem.repository.RoleRepo;
import com.alberto.hospitalSystem.service.DoctorService;

@Controller
public class UrlsController {
	
	@Autowired
	DoctorService service;
	
	@Autowired 
	RoleRepo role_repo;
	
	@RequestMapping("/hospital")
	public String hospital() {

		return "hospital.html";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		
		return "admin.html";
		
	}
	
	@RequestMapping("/")
	public String home() {
		return "home.html";
	}
	

	
}

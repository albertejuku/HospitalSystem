package com.alberto.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alberto.hospitalSystem.model.Hospital;
import com.alberto.hospitalSystem.repository.HospitalRepo;

@Controller
public class HospitalController {
	
	@Autowired
	HospitalRepo hosp_repo;

	
	@RequestMapping(path = "/addHospital")
	public String addHospital(Hospital hospital) {
		hosp_repo.save(hospital);
		return "home.html";
	}
	
}

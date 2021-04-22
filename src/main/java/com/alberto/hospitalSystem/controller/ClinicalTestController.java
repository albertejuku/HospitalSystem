package com.alberto.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.ClinicalTest;
import com.alberto.hospitalSystem.repository.ClinicalTestRepo;
import com.alberto.hospitalSystem.service.PatientService;

@Component
@Controller
public class ClinicalTestController {
	
	@Autowired
	PatientService service;
	
	
	
	@Autowired
	ClinicalTestRepo repo;
	
	
	@RequestMapping(path = "patients/createClinicalTest/{id}")
	public String createClinicalTest(ClinicalTest test, @PathVariable("id") Long id) throws RecordNotFoundException {
		test.setPatient(service.getPatientById(id));
		test.setDetails(test.getDetails());
		test.setResults(test.getResults());
		
		repo.save(test);
		
		return "redirect:/patients";
		
	}

}

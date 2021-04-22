package com.alberto.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Treatment;
import com.alberto.hospitalSystem.repository.TreatmentRepo;
import com.alberto.hospitalSystem.service.PatientService;

@Component
@Controller
public class TreatmentController {
	
	@Autowired
	PatientService service;
	
	
	
	@Autowired
	TreatmentRepo presrepo;
	
	
	@RequestMapping(path = "patients/createTreatment/{id}")
	public String createTreatment(Treatment treatment, @PathVariable("id") Long id) throws RecordNotFoundException {
		treatment.setPatient(service.getPatientById(id));
		treatment.setDetails(treatment.getDetails());
		treatment.setResults(treatment.getResults());
		
		presrepo.save(treatment);
		
		return "redirect:/patients";
		
	}

}

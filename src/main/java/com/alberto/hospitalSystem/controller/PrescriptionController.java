package com.alberto.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Prescription;
import com.alberto.hospitalSystem.repository.PrescriptionRepo;
import com.alberto.hospitalSystem.service.PatientService;

@Component
@Controller
public class PrescriptionController {
	
	@Autowired
	PatientService service;
	
	
	
	@Autowired
	PrescriptionRepo presrepo;
	
	
	@RequestMapping(path = "patients/createPrescription/{id}")
	public String createPrescription(Prescription prescription, @PathVariable("id") Long id) throws RecordNotFoundException {
		prescription.setPatient(service.getPatientById(id));
		prescription.setDetails(prescription.getDetails());
		prescription.setResults(prescription.getResults());
		
		presrepo.save(prescription);
		
		return "redirect:/patients";
		
	}

}

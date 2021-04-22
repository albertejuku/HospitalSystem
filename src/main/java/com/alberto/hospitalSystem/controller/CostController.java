package com.alberto.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Cost;
import com.alberto.hospitalSystem.repository.CostRepo;
import com.alberto.hospitalSystem.service.PatientService;

@Controller
public class CostController {
	
	@Autowired 
	PatientService service;
	
	@Autowired 
	CostRepo repo;
	
	@RequestMapping("patient/cost/{id}")
	public String patientCase(Cost cost, @PathVariable("id") Long id) throws RecordNotFoundException {
				
		cost.setPatient(service.getPatientById(id));
		cost.setAmount_paid(cost.getAmount_paid());
		cost.setTotal_cost(cost.getTotal_cost());
	
		repo.save(cost);
		
		return "redirect:/";
	}
	
	
	
	

}








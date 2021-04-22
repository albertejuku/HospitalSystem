package com.alberto.hospitalSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Doctors;
import com.alberto.hospitalSystem.model.Patient;
import com.alberto.hospitalSystem.service.PatientService;

@Controller
public class PatientController 
{
	@Autowired
	PatientService service;
	
	
	@RequestMapping("/patients")
	public String getAllPatients(Model model) 
	{
		List<Patient> list = service.getAllPatients();

		model.addAttribute("patients", list);
		return "patients.html";
	}
	
	@RequestMapping("/patients/{id}")
	public String getPatientById(Model model, @PathVariable("id") Optional<Long> id) 
			throws RecordNotFoundException
	{
		if (id.isPresent()) {
			Patient entity = service.getPatientById(id.get());
			model.addAttribute("patient", entity);
		} else {
			model.addAttribute("patient", new Doctors());
		}		
		return "patient_single";
	}
	
	
	@RequestMapping(path = "/patients/delete/{id}")
	public String deletePatientsById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deletePatientById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createPatient", method = RequestMethod.GET)
	public String createPatient()
	{
		return "new_patient.html";
	}
	
	@RequestMapping("/createPatient/save")
	public String savePatient(Patient patient) {
		
		service.createOrUpdatePatient(patient);
		
		return "redirect:/patients";
		
	}
	
	
	
	
	
}
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
import com.alberto.hospitalSystem.model.Roles;
import com.alberto.hospitalSystem.repository.RoleRepo;
import com.alberto.hospitalSystem.service.DoctorService;

@Controller
public class DoctorsController 
{
	@Autowired
	DoctorService service;
	
	@Autowired
	RoleRepo roles;
	
	@RequestMapping("/doc_list")
	public String getAllDoctors(Model model) 
	{
		
		List<Roles> role = (List<Roles>) roles.findAll();
		
		
		List<Doctors> list = service.getAllDoctors();
		model.addAttribute("doctors", list);
		model.addAttribute("roles", role);
		return "doctor.html";
	}
	
	@RequestMapping("/doc_list/{id}")
	public String getDoctorById(Model model, @PathVariable("id") Optional<Long> id) 
			throws RecordNotFoundException
	{
		if (id.isPresent()) {
			Doctors entity = service.getDoctorById(id.get());
			model.addAttribute("doctor", entity);
		} else {
			model.addAttribute("doctor", new Doctors());
		}		
		return "single_doctor.html";
	}
	
	
	@RequestMapping(path = "/doctor/delete/{id}")
	public String deleteDoctorById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteDoctorById(id);
		return "redirect:/doc_list";
	}

	@RequestMapping(path = "/createDoctor", method = RequestMethod.GET)
	public String createDoctor() 
	{
		return "new_doc.html";
	}
	
	@RequestMapping("createDoctor/save")
	public String saveDoctor(Doctors doctor) {
		service.createOrUpdateDoctor(doctor);
		
		return "redirect:/doc_list";

	}
	
	
}
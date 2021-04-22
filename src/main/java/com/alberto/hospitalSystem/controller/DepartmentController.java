package com.alberto.hospitalSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Departments;
import com.alberto.hospitalSystem.repository.DepartmentsRepo;
import com.alberto.hospitalSystem.service.DepartmentService;

@Controller
public class DepartmentController 
{
	@Autowired
	DepartmentService service;
	
	@Autowired
	DepartmentsRepo repo;

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editDepartmentById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			Departments entity = service.getDepartmentById(id.get());
			model.addAttribute("department", entity);
		} else {
			model.addAttribute("department", new Departments());
		}
		return "show-department";
	}
	
	@RequestMapping("/createDepartment/save")
	public String createDepartment(Departments department) {
		
		service.createDepartment(department);
		
		return "redirect:/";
	}
	
	@RequestMapping("/createDepartment")
	public String createDepartment() {
		return "new_department.html";
	}
}
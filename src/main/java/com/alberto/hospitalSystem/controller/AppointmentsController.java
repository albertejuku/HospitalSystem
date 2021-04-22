package com.alberto.hospitalSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Appointments;
import com.alberto.hospitalSystem.repository.AppointmentRepo;
import com.alberto.hospitalSystem.repository.CostRepo;
import com.alberto.hospitalSystem.service.AppointmentsService;
import com.alberto.hospitalSystem.service.DoctorService;

@Controller
public class AppointmentsController {
	
	@Autowired
	CostRepo cost;
	
	@Autowired
	DoctorService doc;
	
	@Autowired
	AppointmentRepo repository;
	
	@Autowired
	AppointmentsService service;
	
	@RequestMapping("/saveApps")
	public String createApps() {
		
		return "new_app.html";
		
	}
	
	@RequestMapping("/createApps")
	public String createAppointment(Appointments appointment)
	{
		
		appointment.setDoctor(appointment.getDoctor());
		appointment.setPatient(appointment.getPatient());
		appointment.setTime_created(appointment.getTime_created());
		appointment.setStart_time(appointment.getStart_time());
		appointment.setEnd_time(appointment.getEnd_time());
		appointment.setApp_status(appointment.getApp_status());
		
		repository.save(appointment);
		
		return "redirect:/appointments";
		
	}

	
	@RequestMapping("/appointments")
	public String getAllDoctors(Model model) 
	{
		List<Appointments> list = service.getAllAppointments();

		model.addAttribute("apps", list);
		return "appointments.html";
	}
	
	@RequestMapping("/appointment/{id}")
	public String getAppointmentById(Model model, @PathVariable("id") Optional<Long> id) 
			throws RecordNotFoundException
	{
		if (id.isPresent()) {
			Appointments entity = service.getAppointmetById(null);
			model.addAttribute("appointment", entity);
		} else {
			model.addAttribute("appointment", new Appointments());
		}		
		return "doctor.html";
	}
	
	
	
	@RequestMapping(path = "/deleteapp/{id}")
	public String deleteAppointmentById(Model model, @PathVariable("id") Long id) 
							throws RecordNotFoundException 
	{
		service.deleteAppointmentById(id);
		return "redirect:/admin";
	}
}




//













package com.alberto.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.StatusHistory;
import com.alberto.hospitalSystem.repository.StatusHistoryRepo;
import com.alberto.hospitalSystem.service.AppointmentsService;

@Component
@Controller
public class StatusHistoryController {
	
	@Autowired
	AppointmentsService service;
	
	
	
	@Autowired
	StatusHistoryRepo repo;
	
	
	@RequestMapping(path = "/appointments/status/{id}")
	public String createStatus(StatusHistory status, @PathVariable("id") Long id) throws RecordNotFoundException {
		status.setAppointments(service.getAppointmetById(id));
		status.setDetails(status.getDetails());

		repo.save(status);
		
		return "redirect:/appointments";
		
	}

}

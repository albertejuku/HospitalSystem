package com.alberto.hospitalSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Schedule;
import com.alberto.hospitalSystem.repository.ScheduleRepo;
import com.alberto.hospitalSystem.service.DoctorService;

@Component
@Controller
public class ScheduleController {
	
	@Autowired
	DoctorService docservice;		
	
	@Autowired
	ScheduleRepo schedulerepo;
	
	
	@RequestMapping(path = "doctors/saveSchedule/{id}")
	public String createTreatment(Schedule schedule, @PathVariable("id") Long id) throws RecordNotFoundException {		
		schedule.setDoctor(docservice.getDoctorById(id));
		schedule.setSchedule_date(schedule.getSchedule_date());
		schedule.setStart_time(schedule.getStart_time());
		schedule.setEnd_time(schedule.getEnd_time());
		
		schedulerepo.save(schedule);
		
		return "redirect:/patients";
		
	}

	@RequestMapping("/doctors/createSchedule")
	public String createSchedule() {
		
		return null;
	}
}


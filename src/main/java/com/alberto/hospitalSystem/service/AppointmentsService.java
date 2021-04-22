package com.alberto.hospitalSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Appointments;
import com.alberto.hospitalSystem.repository.AppointmentRepo;
import com.alberto.hospitalSystem.repository.PatientRepo;

@Service
public class AppointmentsService {
	
	@Autowired
	PatientRepo patient;
	
	@Autowired
	DoctorService doc;
	
	@Autowired
	AppointmentRepo repository;
	

	public List<Appointments> getAllAppointments()
	{
		List<Appointments> result = (List<Appointments>) repository.findAll();
		
		System.out.print(result);
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Appointments>();
		}
	}
	
	public Appointments getAppointmetById(Long id) throws RecordNotFoundException 
	{
		Optional<Appointments> appointment = repository.findById(id);
		
		if(appointment.isPresent()) {
			return appointment.get();
		} else {
			throw new RecordNotFoundException("No Appointment record exist for given id");
		}
	}
	
	
	public void deleteAppointmentById(Long id) throws RecordNotFoundException 
	{
		Optional<Appointments> appointment = repository.findById(id);
		
		if(appointment.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Appointment record exist for given id");
		}
	}

}

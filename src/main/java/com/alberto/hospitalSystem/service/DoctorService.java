package com.alberto.hospitalSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Departments;
import com.alberto.hospitalSystem.model.Doctors;
import com.alberto.hospitalSystem.repository.DepartmentsRepo;
import com.alberto.hospitalSystem.repository.DoctorsRepo;

@Service
public class DoctorService {
	
	@Autowired
	DoctorsRepo repository;
	
	@Autowired
	DepartmentsRepo dep_repo;
	
	
	public List<Doctors> getAllDoctors()
	{
		List<Doctors> result = (List<Doctors>) repository.findAll();
		
		System.out.print(result);
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Doctors>();
		}
	}
	
	public Doctors getDoctorById(Long id) throws RecordNotFoundException 
	{
		Optional<Doctors> employee = repository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No Doctors record exist for given id");
		}
	}
	
	public Doctors createOrUpdateDoctor(Doctors doctor) 
	{
		if(doctor.getEmp_id()  == null) 
		{
			doctor = repository.save(doctor);
			
			return doctor;
		} 
		else 
		{
			Optional<Doctors> employee = repository.findById(doctor.getEmp_id());
			dep_repo.findById((long) 29);
			
			if(employee.isPresent()) 
			{
				Doctors newEntity = employee.get();
				newEntity.setEmail(doctor.getEmail());
				newEntity.setFirst_name(doctor.getFirst_name());
				newEntity.setLast_name(doctor.getLast_name());
				newEntity.setIs_active(true);
				newEntity.setDeparment(new Departments());
				newEntity.setDepartment(doctor.getDepartment());

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				doctor = repository.save(doctor);
				
				return doctor;
			}
		}
	} 
	
	public void deleteDoctorById(Long id) throws RecordNotFoundException 
	{
		Optional<Doctors> employee = repository.findById(id);
		
		if(employee.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Doctors record exist for given id");
		}
	}

	

}
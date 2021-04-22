package com.alberto.hospitalSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Patient;
import com.alberto.hospitalSystem.repository.PatientRepo;

@Service
public class PatientService {
	
	@Autowired
	PatientRepo repository;
	

	
	public List<Patient> getAllPatients()
	{
		List<Patient> result = (List<Patient>) repository.findAll();
		
		System.out.print(result);
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Patient>();
		}
	}
	
	public Patient getPatientById(Long id) throws RecordNotFoundException 
	{
		Optional<Patient> patient = repository.findById(id);
		
		if(patient.isPresent()) {
			return patient.get();
		} else {
			throw new RecordNotFoundException("No Patients record exist for given id");
		}
	}
	
	public Patient createOrUpdatePatient(Patient patient) 
	{
		if(patient.getPat_id()  == null) 
		{
			patient = repository.save(patient);
			
			return patient;
		} 
		else 
		{
			Optional<Patient> patient1 = repository.findById(patient.getPat_id());
			
			if(patient1.isPresent()) 
			{
				Patient newEntity = patient1.get();
				newEntity.setEmail(patient.getEmail());
				newEntity.setFirst_name(patient.getFirst_name());
				newEntity.setLast_name(patient.getLast_name());
				newEntity.setPhone(patient.getPhone());
				newEntity.setCase_details(newEntity.getCase_details());
				newEntity.setCase_details(newEntity.getCase_details());
				

				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				patient = repository.save(patient);
				
				return patient;
			}
		}
	} 
	
	public void deletePatientById(Long id) throws RecordNotFoundException 
	{
		Optional<Patient> patient = repository.findById(id);
		
		if(patient.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No Patients record exist for given id");
		}
	}
	

	

}
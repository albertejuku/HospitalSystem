package com.alberto.hospitalSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alberto.hospitalSystem.RecordNotFoundException;
import com.alberto.hospitalSystem.model.Departments;
import com.alberto.hospitalSystem.repository.DepartmentsRepo;
import com.alberto.hospitalSystem.repository.HospitalRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentsRepo repository;
	
	@Autowired 
	HospitalRepo repo;
	
	public List<Departments> getAllDepartments()
	{
		List<Departments> result = (List<Departments>) repository.findAll();
		
		if(result.size() > 0) {
			return result;
		} else {
			return new ArrayList<Departments>();
		}
	}
	
	public Departments getDepartmentById(Long id) throws RecordNotFoundException 
	{
		Optional<Departments> employee = repository.findById(id);
		
		if(employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
	
	public Departments createDepartment(Departments entity) 
	{
		entity.setDep_name(entity.getDep_name());
		entity.setHospital(entity.getHospital());
		
		Departments dep = repository.save(entity);
		return dep;
		
	} 
	
	public void deleteDepartmentbyId(Long id) throws RecordNotFoundException 
	{
		Optional<Departments> employee = repository.findById(id);
		
		if(employee.isPresent()) 
		{
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No department record exist for given id");
		}
	} 

}

package com.alberto.hospitalSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.alberto.hospitalSystem.model.Hospital;

public interface HospitalRepo extends CrudRepository<Hospital, Long>{
	
}

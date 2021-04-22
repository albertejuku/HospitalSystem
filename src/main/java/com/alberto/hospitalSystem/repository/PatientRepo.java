package com.alberto.hospitalSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.alberto.hospitalSystem.model.Patient;

public interface PatientRepo extends CrudRepository<Patient, Long>{

}

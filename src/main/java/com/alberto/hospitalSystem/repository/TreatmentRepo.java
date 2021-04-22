package com.alberto.hospitalSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.alberto.hospitalSystem.model.Treatment;

public interface TreatmentRepo extends CrudRepository<Treatment, Long>{

}

package com.alberto.hospitalSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.alberto.hospitalSystem.model.ClinicalTest;

public interface ClinicalTestRepo extends CrudRepository<ClinicalTest, Long>{

}

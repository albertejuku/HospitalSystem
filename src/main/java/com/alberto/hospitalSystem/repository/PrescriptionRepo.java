package com.alberto.hospitalSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.alberto.hospitalSystem.model.Prescription;

public interface PrescriptionRepo extends CrudRepository<Prescription, Long> {

}

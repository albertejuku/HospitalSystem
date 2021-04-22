package com.alberto.hospitalSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.alberto.hospitalSystem.model.Doctors;

public interface DoctorsRepo extends CrudRepository<Doctors, Long> {

}


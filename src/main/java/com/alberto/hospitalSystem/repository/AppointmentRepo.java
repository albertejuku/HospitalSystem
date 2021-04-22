package com.alberto.hospitalSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.alberto.hospitalSystem.model.Appointments;

public interface AppointmentRepo extends CrudRepository<Appointments, Long>{

}

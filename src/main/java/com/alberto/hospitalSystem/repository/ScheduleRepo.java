package com.alberto.hospitalSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.alberto.hospitalSystem.model.Schedule;

public interface ScheduleRepo extends CrudRepository<Schedule, Long>{

}

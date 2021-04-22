package com.alberto.hospitalSystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.alberto.hospitalSystem.model.StatusHistory;

public interface StatusHistoryRepo extends CrudRepository<StatusHistory, Long>{
	
}
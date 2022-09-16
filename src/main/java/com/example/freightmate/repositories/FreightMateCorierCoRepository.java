package com.example.freightmate.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.freightmate.models.ConsignmentNoteNumberGenerator;

public interface FreightMateCorierCoRepository extends MongoRepository<ConsignmentNoteNumberGenerator, Integer> {

	
	
	
}

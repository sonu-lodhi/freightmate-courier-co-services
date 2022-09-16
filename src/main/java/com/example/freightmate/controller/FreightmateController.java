package com.example.freightmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.freightmate.models.ConsignmentNoteNumberGenerator;
import com.example.freightmate.repositories.FreightMateCorierCoRepository;

@RestController
@RequestMapping(value = "/connote")
public class FreightmateController {

	@Autowired
	private FreightMateCorierCoRepository freightMateCorierCoRepository;
	
	@PostMapping(value = "/addFMCC")
	public ResponseEntity<?> addFreightMateCorierCo(@RequestBody ConsignmentNoteNumberGenerator consignmentNoteNumberGenerator){
		ConsignmentNoteNumberGenerator save = this.freightMateCorierCoRepository.save(consignmentNoteNumberGenerator);
		return ResponseEntity.ok(save);
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<?> getFreightMateCorierCoAll(){
		return ResponseEntity.ok(this.freightMateCorierCoRepository.findAll());
	}
	
}

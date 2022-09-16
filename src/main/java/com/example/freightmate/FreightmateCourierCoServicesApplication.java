package com.example.freightmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.freightmate.models.ConsignmentNoteNumberGenerator;
import com.example.freightmate.services.FreightMateCourierCoService;

@SpringBootApplication
public class FreightmateCourierCoServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreightmateCourierCoServicesApplication.class, args);
	
	
		ConsignmentNoteNumberGenerator consignmentnote = new ConsignmentNoteNumberGenerator("FreightMateCourierCo", "123ABC", 10, 19604, 19000, 20000);
        System.out.println(consignmentnote);

        FreightMateCourierCoService freightMateCourierCoService = new FreightMateCourierCoService();
        String uniqueFreightMateCourierCoIds = freightMateCourierCoService.createConnoteIds(consignmentnote);
        System.out.println(uniqueFreightMateCourierCoIds);
	}
	
	
	
	

}

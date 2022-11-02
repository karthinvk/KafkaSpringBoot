package com.kafka.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.demo.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {
	
	private KafkaProducer kafakProducer;

	public MessageController(KafkaProducer kafakProducer) {
		super();
		this.kafakProducer = kafakProducer;
	}
	
	//http://localhost:8080/api/v1/kafka/publish?message=hello kafka 
	@GetMapping("/publish")
	public  ResponseEntity<String> publish(@RequestParam("message") String message) {
		kafakProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to kafka Topic");
	}
	
	

}

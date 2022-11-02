package com.kafka.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

	private KafkaTemplate<String, String> kafaTemplate;
	
	public KafkaProducer(KafkaTemplate<String, String> kafaTemplate) {
		super();
		this.kafaTemplate = kafaTemplate;
	}
	
	public void sendMessage(String message) {
		logger.info(String.format("Message sent %s", message));
		kafaTemplate.send("testMessage", message);
	}

}

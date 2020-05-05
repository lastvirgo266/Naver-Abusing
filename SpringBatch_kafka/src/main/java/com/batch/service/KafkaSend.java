package com.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.batch.VO.ChatMessage;

@Slf4j
@Service
public class KafkaSend {
	
	
	@Autowired
	private KafkaTemplate<String, ChatMessage> kafaKaTemplate;
	
	
	public void send(String topic, ChatMessage message) {
		log.info(message.getMessage());
		kafaKaTemplate.send(topic, message);
	}
	
	
	public void test(String topic) {
		log.info(topic);
	}
	
	public void test() {
		log.info("ABCDEDF");
	}

}
package com.batch.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.batch.VO.ChatMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaReceiveTest {
	
	@KafkaListener(groupId="spring-boot-test", topics = "test2")
	public void receive(ChatMessage message) {
		log.info(message.getMessage());
	}

	@KafkaListener(groupId="spring-boot-test", topics = "test1")
	public void receive1(ChatMessage message) {
		log.info(message.getMessage());
	}
	
}

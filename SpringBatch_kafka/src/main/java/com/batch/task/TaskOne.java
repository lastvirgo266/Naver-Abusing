package com.batch.task;


import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.batch.VO.ChatMessage;
import com.batch.service.KafkaSend;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskOne implements Tasklet {
	
	private static String DEFAULT_TOPIC = "test1";
	private final KafkaSend sender;
	
	@Autowired
	public TaskOne(KafkaSend sender) {
		this.sender = sender;
	}
	
	
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception{

		log.info("MyTask One Start");
		
		ChatMessage task = new ChatMessage();
		task.setType("TALK");
		task.setMessage("ABCDEFG");
		task.setRoomId("213123");
		task.setSender("TESTER");
		
		log.info(DEFAULT_TOPIC);
		
		sender.send(DEFAULT_TOPIC, task);
		sender.send("test2", task);
		
		log.info("MyTask One End");
		
		return RepeatStatus.FINISHED;
	}

}

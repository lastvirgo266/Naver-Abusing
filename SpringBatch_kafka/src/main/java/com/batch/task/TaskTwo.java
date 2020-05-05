package com.batch.task;


import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskTwo implements Tasklet {
	
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception{

		log.info("MyTask Two Start");
		
		log.info("MyTask Two End");
		
		return RepeatStatus.FINISHED;
	}

}

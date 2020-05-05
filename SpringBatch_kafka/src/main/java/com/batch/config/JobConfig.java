package com.batch.config;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.batch.service.KafkaSend;
import com.batch.task.TaskOne;
import com.batch.task.TaskTwo;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JobConfig {

	
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final KafkaSend sender;

    @Bean
    public Job demoJobOne() {
    	return jobBuilderFactory.get("demoJobOne")
    			.start(stepOne())
    			.next(stepTwo())
    			.build();
    }
    
    @Bean
    public Job demoJobTwp() {
    	return jobBuilderFactory.get("demoJobTwo")
    			.flow(stepOne())
    			.build()
    			.build();
    }
    

    @Bean
    public Step stepOne() {
    	return stepBuilderFactory.get("stepOne")
    			.tasklet(new TaskOne(sender))
    			.build();
    }
    
    @Bean
    public Step stepTwo() {
    	return stepBuilderFactory.get("stepTwo")
    			.tasklet(new TaskTwo())
    			.build();
    }
    

}

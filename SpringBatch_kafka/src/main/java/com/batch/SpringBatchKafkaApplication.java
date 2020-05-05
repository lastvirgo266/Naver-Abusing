package com.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;

import com.batch.config.JobConfig;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatchKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchKafkaApplication.class, args);
	}

}

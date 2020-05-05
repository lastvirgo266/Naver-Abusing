package com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
	
	
	@GetMapping("/check")
	public String Ping() {
		return "pong";
	}

}

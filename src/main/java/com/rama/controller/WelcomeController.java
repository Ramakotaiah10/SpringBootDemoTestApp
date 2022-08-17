package com.rama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rama.service.WelcomeService;

@RestController
public class WelcomeController {

	@Autowired
	private WelcomeService welcomeService;

	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcomeMsg() {

		String message = welcomeService.getMessage();

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}

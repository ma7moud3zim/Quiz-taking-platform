package com.azimquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azimquiz.Service.test.TestService;
import com.azimquiz.dto.TestDTO;

@RestController
@RequestMapping("/api/test")
@CrossOrigin("*")
public class TestController {

	@Autowired
	private TestService testService;
	
	
	@PostMapping()
	public ResponseEntity<?> createTest(@RequestBody TestDTO dto) {
		try {
			TestDTO createdTest = testService.createTest(dto);
			return ResponseEntity.ok(createdTest);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to create test: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

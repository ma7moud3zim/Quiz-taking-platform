package com.azimquiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azimquiz.Service.test.TestService;
import com.azimquiz.dto.QuestionDTO;
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
	
	
	@PostMapping("/question")
	public ResponseEntity<?> addQuestionInTest(@RequestBody QuestionDTO dto) {
		try {
			return new ResponseEntity<>(testService.addQuestionInTest(dto), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to add question: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping()
	public ResponseEntity<?> getAllTests() {
		try {
			return new ResponseEntity<>(testService.getAllTests(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to retrieve tests: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}

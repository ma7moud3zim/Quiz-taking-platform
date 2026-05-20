package com.azimquiz.Service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azimquiz.dto.TestDTO;
import com.azimquiz.entities.Test;
import com.azimquiz.repository.TestRepository;

@Service
public class TestServiceImp implements TestService{
	
	@Autowired
	private TestRepository testRepository;
	
	public TestDTO createTest(TestDTO testDTO) {
		Test test = new Test();
		test.setTitle(testDTO.getTitle());
		test.setDescription(testDTO.getDescription());
		test.setTime(testDTO.getTime());
		
		Test savedTest = testRepository.save(test);
		
		testDTO.setId(savedTest.getId());
		return testDTO;
	}
	
	
}

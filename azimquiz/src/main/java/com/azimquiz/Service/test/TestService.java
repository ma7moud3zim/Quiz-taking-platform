package com.azimquiz.Service.test;

import java.util.List;

import com.azimquiz.dto.QuestionDTO;
import com.azimquiz.dto.TestDTO;
import com.azimquiz.dto.TestDetailsDTO;
import com.azimquiz.entities.Test;

public interface TestService {
	TestDTO createTest(TestDTO dto);
	QuestionDTO addQuestionInTest(QuestionDTO dto);
	List<TestDTO> getAllTests();
	TestDetailsDTO getAllQuestionsByTest(Long id);
}

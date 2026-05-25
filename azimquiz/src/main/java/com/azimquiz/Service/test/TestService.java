package com.azimquiz.Service.test;

import java.util.List;

import com.azimquiz.dto.QuestionDTO;
import com.azimquiz.dto.SubmitTestDTO;
import com.azimquiz.dto.TestDTO;
import com.azimquiz.dto.TestDetailsDTO;
import com.azimquiz.dto.TestResultDTO;
import com.azimquiz.entities.Test;

public interface TestService {
	TestDTO createTest(TestDTO dto);
	QuestionDTO addQuestionInTest(QuestionDTO dto);
	List<TestDTO> getAllTests();
	TestDetailsDTO getAllQuestionsByTest(Long id);
	TestResultDTO submitTest(SubmitTestDTO request);
	List<TestResultDTO> getAllTestResults();
	List<TestResultDTO> getAllTestResultsOfUser(Long userId);
}

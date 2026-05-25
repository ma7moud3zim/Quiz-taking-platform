package com.azimquiz.Service.test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azimquiz.dto.QuestionDTO;
import com.azimquiz.dto.QuestionResponse;
import com.azimquiz.dto.SubmitTestDTO;
import com.azimquiz.dto.TestDTO;
import com.azimquiz.dto.TestDetailsDTO;
import com.azimquiz.dto.TestResultDTO;
import com.azimquiz.entities.Question;
import com.azimquiz.entities.Test;
import com.azimquiz.entities.TestResult;
import com.azimquiz.entities.User;
import com.azimquiz.repository.QuestionRepository;
import com.azimquiz.repository.TestRepository;
import com.azimquiz.repository.TestResultRepository;
import com.azimquiz.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TestServiceImp implements TestService{
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Autowired
	private TestResultRepository testResultRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public TestDTO createTest(TestDTO testDTO) {
		Test test = new Test();
		test.setTitle(testDTO.getTitle());
		test.setDescription(testDTO.getDescription());
		test.setTime(testDTO.getTime());
		
		Test savedTest = testRepository.save(test);
		
		testDTO.setId(savedTest.getId());
		return testDTO;
	}
	
	public QuestionDTO addQuestionInTest(QuestionDTO dto) {
		Optional<Test> testOpt = testRepository.findById(dto.getId());
		if(testOpt.isPresent()) {
			Question question = new Question();
			question.setTest(testOpt.get());
			question.setQuestionText(dto.getQuestionText());
			question.setOptionA(dto.getOptionA());
			question.setOptionB(dto.getOptionB());
			question.setOptionC(dto.getOptionC());
			question.setOptionD(dto.getOptionD());
			question.setCorrectOption(dto.getCorrectOption());			
			
			return  questionRepository.save(question).getDto();
		} else {
			throw new RuntimeException("Test not found with id: " + dto.getId());
		}
	}
	
	public List<TestDTO> getAllTests() {
		return testRepository.findAll().stream().peek(
				test  -> test.setTime(test.getQuestions().size() * test.getTime() ) ).collect(Collectors.toList())
				.stream().map(Test::getDTO).collect(Collectors.toList());
	}
	
	public TestDetailsDTO getAllQuestionsByTest(Long id) {
		Optional<Test> optionalTest = testRepository.findById(id);
		TestDetailsDTO testDetailsDTO = new TestDetailsDTO();
		if(optionalTest.isPresent()) {
			TestDTO testDTO = optionalTest.get().getDTO();
			testDTO.setTime(optionalTest.get().getTime() * optionalTest.get().getQuestions().size());
			
			testDetailsDTO.setTestDTO(testDTO);
			testDetailsDTO.setQuestions(optionalTest.get().getQuestions().stream().map(Question::getDto).toList());
			return testDetailsDTO;
		}
		return testDetailsDTO;
	}
	
	public TestResultDTO submitTest(SubmitTestDTO request) {
		Test test = testRepository.findById(request.getTestId()).orElseThrow(() -> new EntityNotFoundException("Test not found"));
				
		User user = userRepository.findById(request.getUserId()).orElseThrow(() ->new EntityNotFoundException("User not found"));
		
		int correctAnswers =0;
		for(QuestionResponse response: request.getResponses()) {
			Question question = questionRepository.findById(response.getQuestionId()).orElseThrow(() ->new EntityNotFoundException("Question not found"));
			
			if(question.getCorrectOption().equals(response.getSelectedOption())) {
				correctAnswers++;
			}
		}
		int totalQuestions = test.getQuestions().size();
		double percentage = ((double)correctAnswers/totalQuestions) *100;
		 
		TestResult testResult = new TestResult();
		testResult.setTest(test);
		testResult.setUser(user);
		testResult.setTotalQuestions(totalQuestions);
		testResult.setCorrectAnswers(correctAnswers);
		testResult.setPercentage(percentage);
		
		return testResultRepository.save(testResult).getDto();
		
	}
	
	
}

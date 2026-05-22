package com.azimquiz.Service.test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azimquiz.dto.QuestionDTO;
import com.azimquiz.dto.TestDTO;
import com.azimquiz.dto.TestDetailsDTO;
import com.azimquiz.entities.Question;
import com.azimquiz.entities.Test;
import com.azimquiz.repository.QuestionRepository;
import com.azimquiz.repository.TestRepository;

@Service
public class TestServiceImp implements TestService{
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
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
	
	
}

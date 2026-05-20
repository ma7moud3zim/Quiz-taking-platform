package com.azimquiz.entities;

import com.azimquiz.dto.QuestionDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String questionText;
	
	private String optionA;
	
	private String optionB;
	
	private String optionC;
	
	private String optionD;
	
	private String correctOption;
	
	@ManyToOne
	@JoinColumn(name = "test_id")
	private Test test;
	
	public QuestionDTO getDto() {
		QuestionDTO dto = new QuestionDTO();
		dto.setId(this.id);
		dto.setQuestionText(this.questionText);
		dto.setOptionA(this.optionA);
		dto.setOptionB(this.optionB);
		dto.setOptionC(this.optionC);
		dto.setOptionD(this.optionD);
		dto.setCorrectOption(this.correctOption);
		return dto;
	}
	
}

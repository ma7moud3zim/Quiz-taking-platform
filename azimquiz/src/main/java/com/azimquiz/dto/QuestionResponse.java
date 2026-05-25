package com.azimquiz.dto;

import lombok.Data;

@Data
public class QuestionResponse {
	
	private Long questionId;
	private String questionText;
	private String selectedOption;
	
}

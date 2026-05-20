package com.azimquiz.entities;

import com.azimquiz.dto.TestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private Long time;
	
	public TestDTO getDTO() {
		TestDTO dto = new TestDTO();
		dto.setId(this.id);
		dto.setTitle(this.title);
		dto.setDescription(this.description);
		dto.setTime(this.time);
		return dto;
	}
	
}

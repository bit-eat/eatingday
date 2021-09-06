package com.eat.vo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DietVO {
	private Long id;
	private Long memberId;
	private Long categoryId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	private Meal meal;
	private String menu;
	private String categoryName;
	
	

}

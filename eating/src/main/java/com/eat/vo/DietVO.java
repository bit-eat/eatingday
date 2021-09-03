package com.eat.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class DietVO {
	private Long id;
	private Long memberId;
	private Long categoryId;
	private LocalDate date;
	private Meal meal;
	private String menu;
	private String name;
	
	

}

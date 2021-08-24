package com.eat.vo.suggestion;

import java.util.Date;

import lombok.Data;

@Data
public class DietVO {
	private Long id;
	private Long memberId;
	private Long categoryId;
	private Date date;
	private Meal meal;
	private String menu;
}

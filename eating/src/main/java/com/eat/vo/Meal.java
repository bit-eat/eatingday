package com.eat.vo;

public enum Meal {
	BLACKFAST("아침"), LUNCH("점심"), DINNER("저녁"), MEAL("기타");

	private String krName;

	private Meal(String name) {
		this.krName = name;
	}

	public String getKrName() {
		return krName;
	}

}
package com.eat.vo.suggestion;

public enum Meal {
	BLACKFAST("아침"),
	LUNCH("점심"),
	DINNER("저녁"),
	MEAL("기타");
	
	private String krName;
	
	Meal(String krName){this.krName = krName;}
	public String getKrName() {return krName;}
}

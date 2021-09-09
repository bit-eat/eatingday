package com.eat.vo;

public enum Area {
	INCHEON("인천"), GANGBUK("강북"), GANGNAM("강남"), GYEONGBUK("경북"), GYEONGNAM("경남"), GANGWON("강원"), CHUNGCHEONG("충청"),
	DAEJEON("대전"), JEOLLA("전라"), GWANGJU("광주"), DAEGU("대구"), ULSAN("울산"), BUSAN("부산"), GYEONGSANG("경상");

	private String krName;

	private Area(String name) {
		this.krName = name;
	}

	public String getKrName() {
		return krName;
	}
}

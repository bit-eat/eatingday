package com.eat.vo;

import lombok.Data;

@Data
public class EateryVO {
	
    private Long id;
    private Long categoryId;
    private String name;
    private String content;
    private String address;
    private String phoneNumber;
    private Area area;
    private String categoryName;
    
}

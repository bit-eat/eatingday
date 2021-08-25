package com.eat.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecipeVO {

    private Long id;

    private String name;
    private String thumb;
    private String ingredient;
    private People people;
    private int recommend;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private Long categoryId;
    private Long memberId;


}

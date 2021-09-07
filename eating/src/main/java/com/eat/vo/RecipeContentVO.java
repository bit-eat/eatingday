package com.eat.vo;

import lombok.Data;

@Data
public class RecipeContentVO {

    private Long id;

    private String img;
    private String content;
    private int turn;
    private Long recipeId;

}

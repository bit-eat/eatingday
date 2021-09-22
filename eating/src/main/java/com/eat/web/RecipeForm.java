package com.eat.web;

import com.eat.vo.People;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RecipeForm {

    private String name;
    private String thumb;
    private String ingredient;
    private People people;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private String originTag;

    private String content;

}

package com.eat.dao;

import com.eat.vo.SearchStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeSearch {

    private String searchName; //검색단어
    private SearchStatus status; //검색종류

}

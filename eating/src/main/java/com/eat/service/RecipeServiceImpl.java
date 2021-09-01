package com.eat.service;

import com.eat.dao.RecipeContentDAO;
import com.eat.dao.RecipeDAO;
import com.eat.dao.RecipeTagDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeDAO recipeDAO;
    private final RecipeContentDAO contentDAO;
    private final RecipeTagDAO tagDAO;



}

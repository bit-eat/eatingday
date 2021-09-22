package com.eat.controller;

import com.eat.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RecipeService recipeService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/main")
    public String test(){
        return "main";
    }


}

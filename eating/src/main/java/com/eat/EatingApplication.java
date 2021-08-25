package com.eat;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eat.dao.suggestion.CategoryDAO;
import com.eat.vo.suggestion.CategoryVO;

@SpringBootApplication
public class EatingApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EatingApplication.class, args);

	}

}

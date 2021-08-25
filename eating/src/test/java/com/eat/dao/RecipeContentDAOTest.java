package com.eat.dao;

import com.eat.vo.People;
import com.eat.vo.RecipeContentVO;
import com.eat.vo.RecipeVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeContentDAOTest {

    @Autowired
    RecipeDAO recipeDAO;

    @Autowired
    RecipeContentDAO contentDAO;

    @Test
    public void 레시피컨텐츠작성() throws Exception {
        RecipeVO recipeVO = new RecipeVO();

        recipeVO.setName("김치볶음밥");
        recipeVO.setIngredient("밥, 김치, 참치");
        recipeVO.setPeople(People.ONE);
        recipeVO.setCreateDate(LocalDateTime.now());

        recipeDAO.insertRecipe(recipeVO);

        RecipeContentVO content1 = new RecipeContentVO();
        content1.setTurn(1);
        content1.setContent("김치를 버터에 볶는다");
        content1.setRecipeId(recipeVO.getId());

        RecipeContentVO content2 = new RecipeContentVO();
        content2.setTurn(2);
        content2.setContent("참치를 섞어 볶는다");
        content2.setRecipeId(recipeVO.getId());

        contentDAO.insertRecipeContent(content1);
        contentDAO.insertRecipeContent(content2);

        RecipeVO recipeVO1 = recipeDAO.selectOne(recipeVO.getId());
        List<RecipeContentVO> contentList = contentDAO.selectByRecipe(recipeVO1.getId());

        RecipeContentVO recipeContentVO = contentList.get(1);
        System.out.println("조리방법 : " + recipeContentVO.getContent());

        Assertions.assertFalse(contentList.isEmpty());

    }




}
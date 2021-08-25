package com.eat.dao;

import com.eat.vo.People;
import com.eat.vo.RecipeTagVO;
import com.eat.vo.RecipeVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
class RecipeTagDAOTest {

    @Autowired
    RecipeDAO recipeDAO;

    @Autowired
    RecipeTagDAO tagDAO;

    @Test
    public void 태그입력테스트() throws Exception {
        RecipeVO recipeVO = new RecipeVO();
        recipeVO.setName("냉면");
        recipeVO.setPeople(People.ONE);
        recipeVO.setIngredient("면, 육수");
        recipeVO.setCreateDate(LocalDateTime.now());

        recipeDAO.insertRecipe(recipeVO);

        RecipeTagVO recipeTagVO = new RecipeTagVO();
        recipeTagVO.setRecipeId(recipeVO.getId());
        recipeTagVO.setName("냉면");

        tagDAO.insertRecipeTag(recipeTagVO);

        recipeTagVO.setName("여름");
        tagDAO.insertRecipeTag(recipeTagVO);

        RecipeVO recipeVO1 = recipeDAO.selectOne(recipeVO.getId());
        List<RecipeTagVO> recipeTagList = tagDAO.selectByRecipe(recipeVO1.getId());

        System.out.print(recipeVO1.getName() + "의 태그 : ");
        for(int i = 0; i<recipeTagList.size(); i++)
            System.out.print(recipeTagList.get(i).getName() + ", ");

        Assertions.assertFalse(recipeTagList.isEmpty());

    }


}
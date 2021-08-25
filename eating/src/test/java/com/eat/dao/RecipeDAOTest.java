package com.eat.dao;

import com.eat.vo.People;
import com.eat.vo.RecipeVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
public class RecipeDAOTest {

    @Autowired
    private RecipeDAO recipeDAO;

    @Test
    public void 레시피저장(){
        RecipeVO recipeVO = new RecipeVO();
        recipeVO.setName("김치볶음밥");
        recipeVO.setPeople(People.ONE);
        recipeVO.setIngredient("밥, 김치, 참치");
        recipeVO.setCreateDate(LocalDateTime.now());

        recipeDAO.insertRecipe(recipeVO);

        RecipeVO findRecipe = recipeDAO.selectOne(recipeVO.getId());

        System.out.println(findRecipe.getPeople());
        Assertions.assertEquals(recipeVO.getId(), findRecipe.getId());
        //assertEquals(recipeVO.getId(), findRecipe.getId());

    }

    @Test
    public void 레시피이름일부검색() throws Exception {
        RecipeVO recipeVO = new RecipeVO();
        recipeVO.setName("김치볶음밥");
        recipeVO.setPeople(People.ONE);
        recipeVO.setIngredient("밥, 김치, 참치");
        recipeVO.setCreateDate(LocalDateTime.now());

        recipeDAO.insertRecipe(recipeVO);

        List<RecipeVO> findRecipe = recipeDAO.selectName("김치");

        Assertions.assertFalse(findRecipe.isEmpty());
    }

    @Test
    public void 레시피수정() throws Exception {
        RecipeVO recipeVO = new RecipeVO();
        recipeVO.setName("김치볶음밥");
        recipeVO.setPeople(People.ONE);
        recipeVO.setIngredient("밥, 김치, 참치");
        recipeVO.setCreateDate(LocalDateTime.now());

        recipeDAO.insertRecipe(recipeVO);

        RecipeVO recipe = recipeDAO.selectOne(recipeVO.getId());

        System.out.println(recipe.getId());
        System.out.println(recipe.getName());
        System.out.println("작성일 " + recipe.getCreateDate());
        System.out.println("수정일 " + recipe.getModifyDate());

        recipe.setName("감자전");
        recipe.setIngredient("감자, 기름, 전분가루");
        recipe.setPeople(People.TWO);

        recipeDAO.updateRecipe(recipe);

        RecipeVO recipeVO1 = recipeDAO.selectOne(recipe.getId());

        System.out.println(recipeVO1.getId());
        System.out.println(recipeVO1.getName());
        System.out.println("작성일 " + recipeVO1.getCreateDate());
        System.out.println("수정일 " + recipeVO1.getModifyDate());

        Assertions.assertNotEquals(recipeVO1,recipeVO);

    }

    @Test
    public void 레시피삭제() throws Exception {

        RecipeVO recipeVO = new RecipeVO();
        recipeVO.setName("김치볶음밥");
        recipeVO.setPeople(People.ONE);
        recipeVO.setIngredient("밥, 김치, 참치");
        recipeVO.setCreateDate(LocalDateTime.now());

        recipeDAO.insertRecipe(recipeVO);

        RecipeVO recipe = recipeDAO.selectOne(recipeVO.getId());

        recipeDAO.deleteRecipe(recipe.getId());
        RecipeVO recipeVO1 = recipeDAO.selectOne(recipeVO.getId());

        Assertions.assertNull(recipeVO1);

    }



}
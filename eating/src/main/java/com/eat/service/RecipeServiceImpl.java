package com.eat.service;

import com.eat.dao.*;
import com.eat.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeDAO recipeDAO;
    private final RecipeContentDAO contentDAO;
    private final RecipeTagDAO tagDAO;

    @Override
    public Long saveRecipe(RecipeVO recipe) {
        recipeDAO.insertRecipe(recipe);
        return recipe.getId();
    }

    @Override
    public void tempSaveContent(Long id, String content) {
        RecipeContentVO recipeContentVO = new RecipeContentVO();
        recipeContentVO.setRecipeId(id);
        recipeContentVO.setContent(content);
        recipeContentVO.setTurn(0);
        contentDAO.insertRecipeContent(recipeContentVO);
    }

    @Override
    public List<RecipeVO> selectStatus(SearchStatus status, String name) {

        if(status == SearchStatus.TAG && name != null){
           return selectTag(name);
        }else if(status == SearchStatus.INGREDIENT && name != null){
            return selectIngredient(name);
        }else if(status == SearchStatus.NAME && name != null)
            return selectName(name);

        return selectAll();
    }

    @Override
    public void updateRecipe(Long recipeId, String name, String thumb, String ingredient, People p,
                             String originTag, String content) {
        RecipeVO recipeVO = recipeDAO.selectOne(recipeId);
        recipeVO.setThumb("/img/" + thumb);
        recipeVO.setName(name);
        recipeVO.setIngredient(ingredient);
        recipeVO.setPeople(p);
        recipeVO.setModifyDate(LocalDateTime.now());
        recipeDAO.updateRecipe(recipeVO);

        RecipeContentVO recipeContentVO = contentDAO.selectOne(recipeId,0);


        if(recipeContentVO == null){
            RecipeContentVO contentVo = new RecipeContentVO();
            contentVo.setRecipeId(recipeId);
            contentVo.setContent(content);
            contentDAO.insertRecipeContent(contentVo);
        }else {
        recipeContentVO.setContent(content);
        contentDAO.updateRecipeContent(recipeContentVO);
        }

        tagDAO.deleteTagByRecipeId(recipeId);

        String manufactTag = originTag.replace(" ","");
        String tagList[] = manufactTag.split("#");

        int max = 11;

        if(!(tagList.length > max))
            max = tagList.length;

        for(int i=1;i<max; i++){
            RecipeTagVO tagVO = new RecipeTagVO();
            tagVO.setRecipeId(recipeId);
            tagVO.setName(tagList[i]);
            tagDAO.insertRecipeTag(tagVO);
        }

    }

    @Override
    public void deleteRecipe(Long id) {
        //??????-????????? cascade ??????????????? ?????? ???????????? ??????
        recipeDAO.deleteRecipe(id);
    }

    @Override // ????????? true ????????? false
    public boolean bookmarkCheck(Long recipeId, Long memberId) {
        RecipeVO recipeVO = recipeDAO.bookmarkCheck(recipeId, memberId);
        if(recipeVO == null)
            return true;
        return false;
    }

    @Override
    public Long insertRecipeBookmark(Long recipeId, Long memberId) {
        if(bookmarkCheck(recipeId,memberId)){
            RecipeBookmarkVO bookmarkVO = new RecipeBookmarkVO();
            bookmarkVO.setMemberId(memberId);
            bookmarkVO.setRecipeId(recipeId);
            return recipeDAO.insertRecipeBookmark(bookmarkVO);
        }

        return recipeDAO.selectBookmark(recipeId,memberId);
    }

    @Override
    public void deleteRecipeBookmark(Long recipeId, Long memberId) {
        if(bookmarkCheck(recipeId,memberId)){
            return;
        }
        recipeDAO.deleteRecipeBookmark(recipeId,memberId);
    }

    @Override
    public boolean recommendCheck(Long recipeId, Long memberId) {
        RecipeVO recipeVO = recipeDAO.recommendCheck(recipeId, memberId);
        if(recipeVO == null)
            return true;
        return false;
    }

    @Override
    public Long insertRecipeRecommend(Long recipeId, Long memberId) {
        if(recommendCheck(recipeId,memberId)){
            recipeDAO.addRecommend(recipeId);
            RecipeBookmarkVO recipeBookmarkVO = new RecipeBookmarkVO();
            recipeBookmarkVO.setRecipeId(recipeId);
            recipeBookmarkVO.setMemberId(memberId);
            return recipeDAO.insertRecipeRecommend(recipeBookmarkVO);
        }
        return 0L;
    }

    @Override
    public void deleteRecipeRecommend(Long recipeId, Long memberId) {

        if(!recommendCheck(recipeId,memberId)){
            //?????????
           recipeDAO.removeRecommend(recipeId);
           recipeDAO.deleteRecipeRecommend(recipeId,memberId);
        }

        return;
    }

    @Override
    public RecipeVO selectOne(Long id) {
        return recipeDAO.selectOne(id);
    }

    @Override
    public List<RecipeVO> selectAll() {
        return recipeDAO.selectAll();
    }

    @Override
    public List<RecipeVO> selectName(String name) {
        return recipeDAO.selectName(name);
    }


    @Override
    public List<RecipeVO> selectIngredient(String ingredient) {
        return recipeDAO.selectIngredient(ingredient);
    }


    @Override
    public List<RecipeVO> selectTag(String tagName) {
        List<RecipeTagVO> tagVOList = tagDAO.selectByName(tagName);
        List<RecipeVO> recipeList = new ArrayList<>();

        for(RecipeTagVO vo : tagVOList){
            recipeList.add(recipeDAO.selectOne(vo.getRecipeId()));
        }

        return recipeList;
    }


    @Override
    public void manufactureTag(Long recipeId, String originTag) {
        String manufactTag = originTag.replace(" ","");
        String tagList[] = manufactTag.split("#");

        int max = 11;

        if(!(tagList.length > max))
            max = tagList.length;

       for(int i=1;i<max; i++){
           RecipeTagVO tagVO = new RecipeTagVO();
           tagVO.setRecipeId(recipeId);
           tagVO.setName(tagList[i]);
           tagDAO.insertRecipeTag(tagVO);
       }

    }

    @Override
    public String combineTag(Long recipeId) {
        List<RecipeTagVO> recipeTagVOList = tagDAO.selectByRecipe(recipeId);

        if(recipeTagVOList == null)
            return "";

        String tag = "";
        for(RecipeTagVO t : recipeTagVOList){
            tag += "#" + t.getName() + " ";
        }

        return tag;
    }

    @Override
    public RecipeContentVO selectContent(Long recipeId) {
        return contentDAO.selectOne(recipeId, 0);
    }

}

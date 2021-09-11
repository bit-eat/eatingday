package com.eat.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eat.vo.Area;
import com.eat.vo.EateryVO;

public interface EateryService {
   public void insertEatery(EateryVO eatery);
   
   public void updateEatery(EateryVO eatery);
   
   public void deleteEatery(Long id);
   
   public List<EateryVO> selectAll();
   
   public List<EateryVO> selectName(@Param("name")String name);
   
   public List<EateryVO> selectCategoryId(@Param("categoryId")Long categoryId);
   
   public List<EateryVO> selectArea(@Param("area")String area);
   
   public List<EateryVO> LatestEateryList();
   
   public boolean validateDuplicateEatery(EateryVO eatery);
   
}
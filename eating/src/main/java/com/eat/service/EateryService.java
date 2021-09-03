package com.eat.service;

import java.util.List;

import com.eat.vo.Area;
import com.eat.vo.EateryVO;

public interface EateryService {
   public void insertEatery(EateryVO eatery);
   
   public void updateEatery(EateryVO eatery);
   
   public void deleteEatery(Long id);
   
   public List<EateryVO> selectAll();
   
   public List<EateryVO> selectName(String name);
   
   public List<EateryVO> selectCategory(String category);
   
   public List<EateryVO> selectArea(Area area);
   
   public boolean validateDuplicateEatery(EateryVO eatery);
   
}
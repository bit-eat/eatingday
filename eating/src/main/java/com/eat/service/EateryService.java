package com.eat.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eat.vo.Area;
import com.eat.vo.EateryVO;

public interface EateryService {
	
   public void insertEatery(EateryVO eatery);
   
   public void updateEatery(EateryVO eatery);
   
   void updateEateryRecommend(@Param("id") Long id);
   
   public void deleteEatery(Long id);
   
   void updateEateryUnrecommend(@Param("id") Long id);
   
   int checkid(EateryVO eateryvo);
   void deleteMemberRecommend(@Param("id") Long id,@Param("memberId") Long memberid);
   void insertMemberRecommend(@Param("id") Long id,@Param("memberId") Long memberid);
      
   public List<EateryVO> selectAll();
   
   public List<EateryVO> selectName(@Param("name")String name);
   
   public List<EateryVO> selectId(@Param("id") Long id);
   
   public List<EateryVO> selectCategoryName(@Param("categoryName")String categoryName);
   
   public List<EateryVO> selectArea(@Param("area")String area);
   
   public List<EateryVO> LatestEateryList();
   
   public List<EateryVO> RecommendEateryList();
   
   public boolean validateDuplicateEatery(EateryVO eatery);
   
   List<EateryVO> selectAreaRecommend(@Param("area") String area);
   
   List<EateryVO> selectCategoryRecommend(@Param("categoryName")String categoryName);

   public List<EateryVO> selectRecommend();
   
   void adminEaterydelete(@Param("id")List<Long> id);   //관리자 음식점 게시판 삭제
   
}
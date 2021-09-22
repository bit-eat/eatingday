package com.eat.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.eat.vo.Area;
import com.eat.vo.EateryVO;

public interface EateryService {

	void insertEatery(EateryVO eatery);

	void updateEatery(EateryVO eatery);

	void updateEateryRecommend(@Param("id") Long id);
	
	void updateEateryUnrecommend(@Param("id") Long id);

	void deleteEatery(Long id);

	int checkid(EateryVO eateryvo);
	
	int checkingid(EateryVO eateryvo);

	void deleteMemberRecommend(@Param("id") Long id, @Param("memberId") Long memberid);

	void insertMemberRecommend(@Param("id") Long id, @Param("memberId") Long memberid);

	void deleteEateryBookmark(@Param("id") Long id, @Param("memberId") Long memberid);

	void insertEateryBookmark(@Param("id") Long id, @Param("memberId") Long memberid);

	List<EateryVO> selectAll();

	List<EateryVO> selectName(@Param("name") String name);

	List<EateryVO> selectId(@Param("id") Long id);

	List<EateryVO> selectCategoryName(@Param("categoryName") String categoryName);

	List<EateryVO> selectArea(@Param("area") String area);

	List<EateryVO> LatestEateryList();

	List<EateryVO> RecommendEateryList();

	boolean validateDuplicateEatery(EateryVO eatery);

	List<EateryVO> selectAreaRecommend(@Param("area") String area);

	List<EateryVO> selectCategoryRecommend(@Param("categoryName") String categoryName);

	List<EateryVO> selectRecommend();

	void adminEaterydelete(@Param("id") List<Long> id); // 관리자 음식점 게시판 삭제

}
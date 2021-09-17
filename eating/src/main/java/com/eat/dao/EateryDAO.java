package com.eat.dao;

import com.eat.vo.Area;
import com.eat.vo.EateryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EateryDAO {

	void insertEatery(EateryVO eateryvo);

	void insertEateryRecommend(EateryVO eateryvo);

	void updateEatery(EateryVO eateryvo);

	void updateEateryRecommend(@Param("id") Long id);

	void deleteEatery(@Param("id") Long id);

	void updateEateryUnrecommend(@Param("id") Long id);

	int checkid(EateryVO eateryvo);
	
	int checkingid(EateryVO eateryvo);

	void deleteMemberRecommend(@Param("id") Long id, @Param("memberId") Long memberid);

	void insertMemberRecommend(@Param("id") Long id, @Param("memberId") Long memberid);

	void deleteEateryBookmark(@Param("id") Long id, @Param("memberId") Long memberid);

	void insertEateryBookmark(@Param("id") Long id, @Param("memberId") Long memberid);
	
	List<EateryVO> selectAll();

	List<EateryVO> selectId(@Param("id") Long id);

	List<EateryVO> selectName(@Param("name") String name);

	List<EateryVO> selectArea(@Param("area") String area);

	List<EateryVO> selectCategoryName(@Param("categoryName") String categoryName);

	List<EateryVO> LatestEateryList();

	List<EateryVO> RecommendEateryList();

	List<EateryVO> selectAreaRecommend(@Param("area") String area);

	List<EateryVO> selectCategoryRecommend(@Param("categoryName") String categoryName);

	List<EateryVO> selectRecommend();

	void adminEaterydelete(@Param("id") List<Long> id); // 관리자 음식점 게시판 삭제

}

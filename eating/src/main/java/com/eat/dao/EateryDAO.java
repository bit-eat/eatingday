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

	List<EateryVO> selectAll();

	List<EateryVO> selectName(@Param("name") String name);

	List<EateryVO> selectArea(@Param("area") String area);

	List<EateryVO> selectCategoryId(@Param("categoryId") Long category);
	
	List<EateryVO> LatestEateryList();

}

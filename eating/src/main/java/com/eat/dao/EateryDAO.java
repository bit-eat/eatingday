package com.eat.dao;

import com.eat.vo.Area;
import com.eat.vo.EateryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EateryDAO {

    static void insertEatery(EateryVO eatery) {
		// TODO Auto-generated method stub
		
	}

    List<EateryVO> selectAll();
    List<EateryVO> selectName(@Param("name") String name);
    List<EateryVO> selectArea(@Param("area") Area a);
    List<EateryVO> selectCategory(@Param("category") String category);

    void updateEatery(EateryVO eatery);
    void deleteEatery(@Param("id") Long id);


}


	   
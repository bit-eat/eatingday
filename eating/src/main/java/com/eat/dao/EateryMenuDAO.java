package com.eat.dao;

import com.eat.vo.EateryMenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EateryMenuDAO {

    void insertEateryMenu(EateryMenuVO eaterymenu);

    List<EateryMenuVO> selectMenu(@Param("menu") int menu);

    void updateEatery(EateryMenuVO eaterymenu);
    void deleteEatery(@Param("id") Long id);


}

   

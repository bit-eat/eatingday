package com.eat.dao;

import com.eat.vo.EateryBookmarkVO;
import com.eat.vo.EateryVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EateryBookmarkDAO {

    void insertEateryBookmark(EateryBookmarkVO eaterybookmarkvo);
    
    List<EateryBookmarkVO> selectMemberId(@Param("name") String name);
    
    List<EateryBookmarkVO> selectEateryBookmark(@Param("id") Long id);
    
    void deleteEateryBookmark(@Param("id") Long id);

}

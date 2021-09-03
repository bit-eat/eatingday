package com.eat.dao;

import com.eat.vo.EateryBookmarkVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EateryBookmarkDAO {

    void insertEateryBookmark(EateryBookmarkVO eaterybookmark);
    
    List<EateryBookmarkVO> selectMemberId(@Param("name") String name);
    
    void deleteEateryBookmark(@Param("id") Long id);

}

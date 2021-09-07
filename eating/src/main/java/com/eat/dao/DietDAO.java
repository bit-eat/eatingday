package com.eat.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.RequestParam;

import com.eat.vo.DietVO;
import com.eat.vo.Meal;

@Mapper
public interface DietDAO {
	public void insertDiet(DietVO dietVO);
	public void updateDiet(DietVO dietVO);
	public void deleteDiet(DietVO dietVO);
	public List<DietVO> showDietList();
	public List<DietVO> selectDietList(@Param("date")LocalDate date,@Param("date2")LocalDate date2);
}

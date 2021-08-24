package com.eat.dao.suggestion;

import java.util.Date;
import java.util.List;

import com.eat.vo.suggestion.DietVO;

public interface DietDAO {
	public void insertDiet(DietVO dietVO);
	public void updateDiet(DietVO dietVO);
	public void deletdDiet(Long id);
	public List<DietVO> showDietList();
	public List<DietVO> selectDietList(Date date);
}

package com.eat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eat.dao.EateryDAO;
import com.eat.vo.Area;
import com.eat.vo.EateryVO;

@Service
public class EateryServiceImpl implements EateryService {
	
	@Autowired
	EateryDAO eaterydao;

	@Override
	public void insertEatery(EateryVO eatery) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEatery(EateryVO eatery) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEatery(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EateryVO> selectAll() {
		// TODO Auto-generated method stub
		return eaterydao.selectAll();
	}

	@Override
	public List<EateryVO> selectName(String name) {
		// TODO Auto-generated method stub
		return eaterydao.selectName(name);
	}

	@Override
	public List<EateryVO> selectCategory(String category) {
		// TODO Auto-generated method stub
		return eaterydao.selectCategory(category);
	}

	@Override
	public List<EateryVO> selectArea(Area area) {
		// TODO Auto-generated method stub
		return eaterydao.selectArea(area);
	}

	@Override
	public boolean validateDuplicateEatery(EateryVO eatery) {
		// TODO Auto-generated method stub
		return false;
	}



}

package com.eat.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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
	public void insertEatery(EateryVO eateryvo) {
		// TODO Auto-generated method stub
	  eaterydao.insertEatery(eateryvo);
	  eaterydao.insertEateryRecommend(eateryvo);
	}
	
	@Override
	public void updateEatery(EateryVO eatery) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateEateryRecommend(Long id) {
		// TODO Auto-generated method stub
		eaterydao.updateEateryRecommend(id);
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
	public List<EateryVO> selectCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return eaterydao.selectCategoryRecommend(categoryName);
	}

	@Override
	public List<EateryVO> selectArea(String area) {
		// TODO Auto-generated method stub
		Area[] areas = Area.values();
		for(Area area1 : areas) {
			if(area1.getKrName().equals(area)) {
				area = area1.name();
			}
		}
		return eaterydao.selectArea(area);
	}
	
	@Override
	public List<EateryVO> LatestEateryList() {
		return eaterydao.LatestEateryList();
	}
	
	@Override
	public List<EateryVO> RecommendEateryList() {
		// TODO Auto-generated method stub
		return eaterydao.RecommendEateryList();
	}
	@Override
	public boolean validateDuplicateEatery(EateryVO eatery) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<EateryVO> selectAreaRecommend(String area) {
		Area[] areas = Area.values();
		for(Area area1 : areas) {
			if(area1.getKrName().equals(area)) {
				area = area1.name();
			}
		}
		return eaterydao.selectAreaRecommend(area);
	}

	@Override
	public List<EateryVO> selectCategoryRecommend(String categoryName) {
		
		return eaterydao.selectCategoryRecommend(categoryName);
	}

}

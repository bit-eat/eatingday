package com.eat.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eat.vo.Area;
import com.eat.vo.EateryVO;

import java.util.List;


@SpringBootTest
public class EateryDAOTest {

    @Autowired
    private EateryDAO eateryDAO;

    @Test
    public void 맛집등록(){
        EateryVO eateryVO = new EateryVO();
        eateryVO.setName("에그드랍");
        eateryVO.setContent("샌드위치");
        eateryVO.setAddress("부산");
        eateryVO.setPhoneNumber("222-2222");
        eateryVO.setArea(Area.BUSAN);

        EateryDAO.insertEatery(eateryVO);

    }

    @Test
    public void 맛집검색() throws Exception {
    	EateryVO eateryVO = new EateryVO();
        eateryVO.setName("에그드랍");
        eateryVO.setContent("샌드위치");
        eateryVO.setAddress("부산");
        eateryVO.setPhoneNumber("222-2222");
        eateryVO.setArea(Area.BUSAN);

        EateryDAO.insertEatery(eateryVO);

        List<EateryVO> findEatery = eateryDAO.selectName("에그드랍");

        Assertions.assertFalse(findEatery.isEmpty());
    }


}
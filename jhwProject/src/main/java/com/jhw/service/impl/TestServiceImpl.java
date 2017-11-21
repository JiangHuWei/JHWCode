package com.jhw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhw.dao.TestPoJoMapper;
import com.jhw.pojo.TestPoJo;
import com.jhw.service.TestService;

/**
 * 
 * @ClassName TestServiceImpl
 * @Description TODO()
 * @author Administrator
 * @Date 2017年9月22日 下午12:34:37
 * @version 1.0.0
 */
@Service("TestService")
public class TestServiceImpl implements TestService {

	@Autowired
	TestPoJoMapper testDao;
	
	@Override
	public List<TestPoJo> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

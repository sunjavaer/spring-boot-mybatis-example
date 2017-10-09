package com.lvliang.learn.springboot.mybatis.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lvliang.learn.springboot.mybatis.mapper.IndexMapper;
import com.lvliang.learn.springboot.mybatis.model.TestMybatis;

@Service
public class IndexService {
	
	private Logger log = LoggerFactory.getLogger(IndexService.class);
	
	@Autowired
	private IndexMapper mapper;

	public TestMybatis getOneContent() {
		log.debug("getOneContent");
		return mapper.getOneContent();
	}

	public Integer insertAll() {
		log.debug("insertAll begin");
		Integer count = 10;
		List<TestMybatis> testMyBatisList = new ArrayList<TestMybatis>(count);
		for(int i = 0; i < count; i++) {
			TestMybatis model = new TestMybatis();
			model.setName("runjing");
			testMyBatisList.add(model);
		}
		
		count = mapper.insertAll(testMyBatisList);
		log.debug("insertAll end");
		
		return count;
	}

	public List<TestMybatis> getAllContent(Integer pageNum, Integer pageSize) {
		log.debug("getAllContent");
		PageHelper.startPage(pageNum, pageSize);
		return mapper.getAllContent();
	}

	public void deleteAllContent() {
		mapper.deleteAllContent();
	}
}

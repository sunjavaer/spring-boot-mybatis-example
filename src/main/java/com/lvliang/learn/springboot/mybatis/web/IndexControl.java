package com.lvliang.learn.springboot.mybatis.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.lvliang.learn.springboot.mybatis.model.TestMybatis;
import com.lvliang.learn.springboot.mybatis.service.IndexService;

@RestController
public class IndexControl {
	
	private Logger log = LoggerFactory.getLogger(IndexControl.class);
	
	@Autowired
	private IndexService service;
	
	@GetMapping("/")
	public String home() {
		log.debug("access /");
		return "hello, home";
	}
	
	@GetMapping("/getOneContent")
	public String getOneContent() {
		log.debug("access /getOneContent");
		TestMybatis testMybatis = service.getOneContent();
		return testMybatis.toString();
	}
	
	@GetMapping("/insertAll")
	public String insertAll() {
		log.debug("access /insertAll");
		Integer count = service.insertAll();
		return "success " + count;
	}
	
	@GetMapping("/getAllContent")
	public List<TestMybatis> getAllContent(@RequestParam(defaultValue="1") Integer pageNum,
			                               @RequestParam(defaultValue="10") Integer pageSize) {
		log.debug("access /getAllContent pageNum: " + pageNum + " pageSize: " + pageSize);
		List<TestMybatis> testMybatisList = service.getAllContent(pageNum, pageSize);

		Page page = (Page)testMybatisList;
		log.debug("pageNum " + page.getPageNum());
		log.debug("pageSize " + page.getPageSize());
		log.debug("startRow " + page.getStartRow());
		log.debug("endRow " + page.getEndRow());
		log.debug("total " + page.getTotal());
		log.debug("pages " + page.getPages());
		
		for (TestMybatis testMybatis : testMybatisList) {
			log.debug(testMybatis.toString());
		}
		
		return testMybatisList;
	}
	
	@GetMapping("/deleteAllContent")
	public String deleteAllContent() {
		service.deleteAllContent();
		
		return "success";
	}

}

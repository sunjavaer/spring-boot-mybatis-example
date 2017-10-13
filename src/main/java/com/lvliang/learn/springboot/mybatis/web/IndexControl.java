package com.lvliang.learn.springboot.mybatis.web;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.lvliang.learn.springboot.mybatis.model.CallBack;
import com.lvliang.learn.springboot.mybatis.model.TestMybatis;
import com.lvliang.learn.springboot.mybatis.service.IndexService;

@RestController
public class IndexControl {
	
	private Logger log = LoggerFactory.getLogger(IndexControl.class);
	
	@Autowired
	private IndexService service;
	
	@GetMapping("/")
	public ModelAndView home() {
		log.debug("access /");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("value", "hello, world");
		
		
//		RestTemplate template = new RestTemplate();
//		List<TestMybatis> testMybatisList = template.getForObject("http://localhost:8080/getAllContent", List.class, String.class);
//		log.debug(testMybatisList.get(0).toString());
		
		TestMybatis bean = new TestMybatis();
		bean.setName("bean value from control");
		mv.addObject("bean_value", bean);
		mv.addObject("date", new Date());
		
		mv.addObject("title_name", "thymeleaf");
		
		return mv;
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
	
	@PostMapping(path="/submitForm", 
			     consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
			     produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CallBack submitForm(@RequestBody TestMybatis testMybatis) {
		log.debug("param: " + testMybatis.toString());
		
		CallBack callBack = new CallBack();
		callBack.setIsOK("1");
		return callBack;
	}
	
	@GetMapping("/queryTestMybatis")
	public List<TestMybatis> queryTestMybatis(@RequestParam(defaultValue="") String name,
			                                  @RequestParam(defaultValue="") String statusCode) {
		log.debug("name: " + name);
		log.debug("statusCode: " + statusCode);
		
		return service.queryTestMybatis(name, statusCode);
	}
}

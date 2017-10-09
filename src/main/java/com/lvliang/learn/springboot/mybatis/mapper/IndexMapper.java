package com.lvliang.learn.springboot.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lvliang.learn.springboot.mybatis.model.TestMybatis;

@Mapper
public interface IndexMapper {
	
	public TestMybatis getOneContent();

	public Integer insertAll(List<TestMybatis> testMyBatisList);

	public List<TestMybatis> getAllContent();

	public void deleteAllContent();

}

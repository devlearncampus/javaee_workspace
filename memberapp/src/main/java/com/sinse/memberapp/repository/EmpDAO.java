package com.sinse.memberapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.memberapp.mybatis.MybatisConfig;

public class EmpDAO {
	
	MybatisConfig config=MybatisConfig.getInstance();
	
	public List selectAll() {
		SqlSession sqlSession=config.getSqlSession();
		List list=sqlSession.selectList("Emp.selectAll");
		sqlSession.close();
		return list;
	}
}













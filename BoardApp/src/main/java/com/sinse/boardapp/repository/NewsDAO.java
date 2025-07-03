package com.sinse.boardapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.boardapp.exception.NewsException;
import com.sinse.boardapp.model.News;
import com.sinse.boardapp.mybatis.MybatisConfig;

//DAO의 존재는 그래도 유지하되, dao의 CRUD 메서드 안에 상투적 jdbc코드를 작성하지 않는다..
//Mybatis 프레임웍(SQL Mapper)과 Hibernate(ORM) 프레임웍을 이용하기 때문...
public class NewsDAO {
	MybatisConfig config=MybatisConfig.getInstance();
	
	//모든 레코드 가져오기
	public List selectAll(){
		return null;
	};
	
	//한건 가져오기 
	public News select(int news_id) {
		return null;
	}
	
	//한건 넣기
	public void insert(News news) throws NewsException{
		SqlSession sqlSession=config.getSqlSession();
		int result = sqlSession.insert("News.insert", news);
		if(result <1) {
			throw new NewsException("등록 실패");
		}
		sqlSession.commit();
	}
	
	//한건 수정 
	public void update(News news) {}
	
	//한건 삭제 
	public void delete(int news_id) {}
	
}














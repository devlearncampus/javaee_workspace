package com.sinse.boardapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sinse.boardapp.exception.CommentException;
import com.sinse.boardapp.model.Comment;
import com.sinse.boardapp.mybatis.MybatisConfig;

public class CommentDAO {
	
	MybatisConfig config=MybatisConfig.getInstance();
	
	public List selctAll() {
		return null;
	}
	public Comment select(int comment_id) {
		return null;
	}
	
	public void insert(Comment comment) {	
		SqlSession sqlSession=config.getSqlSession();
		int result=sqlSession.insert("Comment.insert", comment);
		if(result <1) {
			throw new CommentException("등록 실패");
		}
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void update(Comment comment) {		
	}
	public void delete(int comment_id) {
	}
}








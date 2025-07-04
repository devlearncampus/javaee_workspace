package com.sinse.memberapp.repository;

import org.apache.ibatis.session.SqlSession;
import com.sinse.memberapp.model.Member;
import com.sinse.memberapp.mybatis.MybatisConfig;

public class MemberDAO {
	MybatisConfig config=MybatisConfig.getInstance();
	
	public Member login(Member member) {
		SqlSession sqlSession=config.getSqlSession();
		Member obj=sqlSession.selectOne("Member.login", member);
		sqlSession.close();
		return obj;
	}
}











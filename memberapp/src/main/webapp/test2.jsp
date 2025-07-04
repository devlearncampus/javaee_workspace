<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="com.sinse.memberapp.mybatis.MybatisConfig"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	MybatisConfig conf=MybatisConfig.getInstance();	
	SqlSession sqlSession=conf.getSqlSession();
	out.print(sqlSession);
	
%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//자바 코드안에 로직이 아닌 설정 정보를 직접 작성하면 유지보수성이 떨어질 수있음
	//데이터베이스연동 정보, 이메일설정 정보, 업로드 파일의 경로..
	//이때 개발자는 자바코드 밖의 외부 설정파일에 자원을 관리할 수 있는데, 이 기술을
	//가리켜 JNDI(Java Naming Directory Interface)
	//설정 정보를 외부에 두고서, 이름으로 찾아서 자원을 접근하는 기술 
	//이 실습은 여러 자원들 중 JNDI로 관리할 대상이 아파치에서 만든 커넥션풀인것뿐이다
	InitialContext context=new InitialContext();
	
	//server.xml에 명시된 jndi/mysql 이라는 이름으로 검색 시작 
	DataSource ds=(DataSource)context.lookup("java:comp/env/jndi/mysql");
	Connection con=ds.getConnection();//풀로부터 커넥션 하나 꺼내기
	out.print(con);
%>










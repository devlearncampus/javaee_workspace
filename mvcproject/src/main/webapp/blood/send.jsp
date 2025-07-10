<%@page import="mvcproject.blood.model.BloodManager"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	/*
	모델1 방식: JSP 또는 서블릿이 MVC 중 VC를 담당하는 개발방식 
	모델2 방식: MVC 패턴을 JavaEE 기술로 구현해놓은 모델 
					Model : .java(Plain Old Java Object)
								참고) POJO 유래: 초창기 JAVA가 세상에 이름을 알리기 시작하자, 엔터프라즈
										시장을 노림...컴포넌트 기반의 JAVA 기술 -> 기업용 자바 (JavaEE)
										javaEE(Enterprise Java Bean-많이는 쓰였으나, 자바기술을 너무
												벗어남..순수한 자바기술로 보기 힘들정도..트랜잭션 자동처리
												예외,이메일..)
										로드 존슨이 책을 씀(Expert one on one) - EJB 자바가 아니다..
										시범) 순수자바(POJO)+xml 만으로도 자동 트랙잭션 가능하다..증명..
											 그리고 로드 존슨은 자신이 만든 프로그램을 가리켜 스프링..
					View : 보여지는 부분은 jsp로 구현
					Controller :  Servlet 으로 구현 			
	*/
	//jsp 파일 하나로 모든 것을 처리하는 방법 
	
	String msg=null;
	out.print(msg);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/blood.do" method="post">	
		<select name="blood">
			<option value="">색상 선택</option>		
			<option value="A">A형</option>		
			<option value="B">B형</option>		
			<option value="O">O형</option>		
			<option value="AB">AB형</option>		
		</select>
		<button>전송</button>
	</form>
	
</body>
</html>









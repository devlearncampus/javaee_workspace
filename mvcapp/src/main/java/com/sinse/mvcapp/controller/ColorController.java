package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinse.mvcapp.color.model.ColorManager;

/*
 * MVC 패턴에 의해 디자인과 로직을 분리시키려면, 중간에 중재자가 나서야 하므로, 코드에서 분리 
 * 왜 서블릿으로 정의하고 잇나?  
 * 1) JSP는 View로 사용할 것이므로 ..
 * 2) 웹기반의 컨트롤러는 클라이언트의 요청을 받는 능력이 잇어야 하므로 .  
 * */
public class ColorController extends HttpServlet{
	ColorManager manager=new ColorManager();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*컨트롤러의 5대 업무
		 * 1) 요청을 받는다
		 * 2) 요청을 분석한다 
		 * 3) 알맞는 로직객체(모델)에 일 시킨다(직접 하지 않는다)
			4) 결과에 보여질 데이터를 보관 
		 * 5) 알맞는 결과를 보여준다 
		*/
		
		String color=request.getParameter("color");
		String result=manager.getAdvice(color);
		
		//여기서 절대로 결과를 출력하면 안됨...MVC로 분리해야 하므로 컨트롤러가 View 역할을 해서는 
		//안됨..
		HttpSession session=request.getSession();
		session.setAttribute("msg", result);//세션에 보관...
		
		//result.jsp를 클라이언트가 보도록 처리.. .
		//클라이언트로 하여금 지정된 url로 다시 요청을 시도하도록 강제
		//즉 톰켓이 응답정보를 이용하여 응답 컨텐츠를 보내고 나서, 클라이인트가 다시 접속할 주소..
		response.sendRedirect("/color/result.jsp"); 
		// <script>location.href='/color/result.jsp'</script> 와 동일한 효과를 냄
	}
}














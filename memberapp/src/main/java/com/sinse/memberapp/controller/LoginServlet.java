package com.sinse.memberapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinse.memberapp.exception.MemberNotFoundException;
import com.sinse.memberapp.model.Member;
import com.sinse.memberapp.repository.MemberDAO;

//post로 전송되어 오는 로그인 정보를 받아, 회원테이블과 일치여부에 따라
//로그인 성공 및 실패..
public class LoginServlet extends HttpServlet{
	Logger logger=LoggerFactory.getLogger(getClass());
	MemberDAO memberDAO=new MemberDAO();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라미터 받기 
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		for(int i=1;i<=10;i++) {
			logger.trace("i는 "+i);
		}
		logger.debug("넘겨받은 아이디 "+id);
		logger.debug("넘겨받은 비번 "+pwd);
		
		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		
		Member obj=null;
		try {
			obj=memberDAO.login(member);
			
			//로그인이 성공되면, 세션 객체에 담자!!!
			//jsp에서는 내장객체로써, session 이 지원되지만 현재 이 코드는 서블릿이기 때문에 개발자가
			//자료형으로 제어해야 함 
			HttpSession session=request.getSession();//현재 이 요청에 의해 할당된 세션
			session.setAttribute("member", obj);
			
			out.print("alert('"+obj.getName()+" 님 반갑습니다.');");
			out.print("location.href='/index.jsp';");
		} catch (MemberNotFoundException e) {
			e.printStackTrace();
			out.print("alert('"+e.getMessage()+"');");
			out.print("history.back();");
		}
		out.print("</script>");
		/*
		logger.trace("trace 레벨 출력");
		logger.debug("debug 레벨 출력");
		logger.info("info 레벨 출력");
		logger.warn("warn 레벨 출력");
		logger.error("error 레벨 출력 ");
		*/
	}
}











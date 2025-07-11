package myframework.admin.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import myframework.web.servlet.Controller;

public class ListController implements Controller{
	Logger logger=LoggerFactory.getLogger(getClass());
	
	@Override
	public void execute(HttpServletRequest requet, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("목록 요청 받음");
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return false;
	}
	
}	

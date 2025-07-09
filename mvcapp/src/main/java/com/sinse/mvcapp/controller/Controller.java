package com.sinse.mvcapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 컨트롤러들의 최상위 객체 정의, 
public interface Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

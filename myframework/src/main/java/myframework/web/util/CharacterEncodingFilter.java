package myframework.web.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	String encoding;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);//Go ahead
	}
	
	@Override
	public void destroy() {
		
	}

	
}









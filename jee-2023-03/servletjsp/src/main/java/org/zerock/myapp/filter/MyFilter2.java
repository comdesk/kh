package org.zerock.myapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

//@WebFilter(
//		urlPatterns = { 
//			"/Hello", 
//			"/ContextParam"
//		}, 
//		initParams = { 
//			@WebInitParam(name = "name", value = "Yoseph"), 
//			@WebInitParam(name = "age", value = "23")
//		})
public class MyFilter2 extends HttpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException {
		log.trace("doFilter(req,res,chain) invoked.");
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(req, res);
	}
} //end class







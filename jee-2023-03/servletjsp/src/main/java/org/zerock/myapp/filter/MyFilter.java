package org.zerock.myapp.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

//@WebFilter("/*")	//URL-pattern matching
public class MyFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;	//고정시켜놓는 게 좋음.(이해 못함..)

	@Resource(name="jdbc/OracleCloudATPWithDriverSpy")
	private DataSource dataSource;
	
//	public MyFilter() {
//        super();	//부모 생성자는 아무것도 안 함.
//        
//        log.trace("Default constructor invoked.");
//    } //default constructor

//    @Override
//	public void destroy() {
//    	log.trace("destroy() invoked.");
//	} //destroy
    
    @Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    	log.trace("doFilter({}, {}, {}) invoked.", req, res, chain);
    	log.info("\t+ this.dataSource: {}", this.dataSource);
//    	log.info("req type: {}", req.getClass().getName());
//    	log.info(">>>>>>>>Request URI: {}", req.getRequestURI());
    	
//    	============================================================    	
    	//1. Place your Pre-processing codes here. (Pre-processing)
//    	============================================================   
    	log.info("\t+ Pre-processing codes.");	
    	
//    	============================================================   
		//2. pass the request along the filter chain(건드리면 안 됨.)
//    	============================================================   
		chain.doFilter(req, res);
		
//    	============================================================   
		//3. Place your Post-processing codes here. (Post-processing)
//    	============================================================   
    	log.info("\t+ Post-processing codes.");    	
    } //doFilter

//    @Override
//	public void init(FilterConfig fConfig) throws ServletException {
//    	log.trace("init({}) invoked.", fConfig);
//	} //init

} //end class

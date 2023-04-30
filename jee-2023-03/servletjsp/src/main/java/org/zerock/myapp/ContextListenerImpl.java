package org.zerock.myapp;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

//@WebListener
public class ContextListenerImpl 
	implements ServletContextListener {
	
	@Resource(name="jdbc/OracleCloudATPWithDriverSpy")
	private DataSource dataSource;
	
//    public ContextListenerImpl() {
//		log.trace("Default Constructor Invoked.");
//	} //default constructor

    @Override
	public void contextDestroyed(ServletContextEvent sce)  { 
    	log.trace("contextDestroyed({}) Invoked.", sce);  	
    	
    } //contextDestroyed

    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
    	log.trace("contextInitialized({}) Invoked.", sce);
    	log.info("\t+ this.dataSource: {}", this.dataSource);
    	
    	ServletContext sc = sce.getServletContext();
    	Object source = sce.getSource();
    	
    	log.info("\t+sc({}), source({})", sc, source);
    } //contextInitialized
	
} //end class







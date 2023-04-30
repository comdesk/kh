package org.zerock.myapp.quartz.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommonDataSource {		//Singleton Pattern

	private static final CommonDataSource _self = new CommonDataSource();
	private final DataSource dataSource;
	
	private CommonDataSource() {
		HikariConfig conf = new HikariConfig();
		conf.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		conf.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@khdatabasestudy_high?TNS_ADMIN=C:/opt/OracleCloudWallet/FIN");
		conf.setUsername("ADMIN");
		conf.setPassword("Oracle13245678");
		
		conf.setMinimumIdle(5);
		conf.setMaximumPoolSize(20);
		
//		---
		
		this.dataSource = new HikariDataSource(conf);
		Objects.requireNonNull(this.dataSource);
		log.info("\t+ this.dataSource: {}", this.dataSource);
	} //default constructor
	
	public static synchronized CommonDataSource getInstance() {
		return _self;
	} //getInstance
	
	public Connection getConnection() throws SQLException{
		return this.dataSource.getConnection();
	} //getConnection
	
//	public void close(Connection conn) {	//자원을 닫을 땐 오류가 나도 해줄 게 없음.
//		try {conn.close();}					//자원 닫는 건 롬복의 어노테이션 등으로 맡길 수 잇어서 이 메소드는 제공 안 할 수도 있음.
//		catch(Exception e) {;;}
//	} //close
} //end class









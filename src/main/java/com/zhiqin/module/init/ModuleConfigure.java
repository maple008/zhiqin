package com.zhiqin.module.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * 应用配置属性类
 * @author lyf
 *
 */
@Configuration
public class ModuleConfigure {
	
	/** 数据库url **/
	@Value("${database.url}")
    private String databaseUrl;
	
	/** hibernate 数据库方言 **/
	@Value("${database.dialect}")
    private String databaseDialect;
	
	/** 数据库驱动 **/
	@Value("${database.driver}")
    private String databaseDriver;
	
	/** 数据库用户名称 **/
	@Value("${database.user}")
    private String databaseUser;
	
	/** 数据库密码 **/
	@Value("${database.password}")
    private String databasePassword;
	
	@Value("${database.maxPoolPreparedStatementPer}")
	private int maxPoolPreparedStatementPer;
	
	public int getMaxPoolPreparedStatementPer() {
		return maxPoolPreparedStatementPer;
	}
	public void setMaxPoolPreparedStatementPer(int maxPoolPreparedStatementPer) {
		this.maxPoolPreparedStatementPer = maxPoolPreparedStatementPer;
	}
	public String getDatabaseUrl() {
		return databaseUrl;
	}
	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}
	public String getDatabaseDialect() {
		return databaseDialect;
	}
	public void setDatabaseDialect(String databaseDialect) {
		this.databaseDialect = databaseDialect;
	}
	public String getDatabaseDriver() {
		return databaseDriver;
	}
	public void setDatabaseDriver(String databaseDriver) {
		this.databaseDriver = databaseDriver;
	}
	public String getDatabaseUser() {
		return databaseUser;
	}
	public void setDatabaseUser(String databaseUser) {
		this.databaseUser = databaseUser;
	}
	public String getDatabasePassword() {
		return databasePassword;
	}
	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	} 
}

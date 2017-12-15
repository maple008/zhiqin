package com.zhiqin.module.init;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;


/**
 * 数据库配置类
 *
 * @author lyf
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.zhiqin.module.sql.repository")
public class DataConfig {
    @Autowired
    ModuleConfigure moduleConfigure;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        //  vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPackagesToScan("com.zhiqin.module.sql.entity");
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setDataSource(dataSourceDruid());
        entityManagerFactory.setJpaPropertyMap(new HashMap<String, String>() {{
            //   put("hibernate.hbm2ddl.auto", "update");
            put("hibernate.dialect", moduleConfigure.getDatabaseDialect());
        }});
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory().getObject());

        return transactionManager;
    }


    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSourceDruid() {
        final DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(moduleConfigure.getDatabaseDriver());
        dataSource.setUrl(moduleConfigure.getDatabaseUrl());
        dataSource.setPassword(moduleConfigure.getDatabasePassword());
        dataSource.setUsername(moduleConfigure.getDatabaseUser());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(moduleConfigure.getMaxPoolPreparedStatementPer());
        dataSource.setPoolPreparedStatements(true);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMaxWait(60000);
        dataSource.setMaxActive(20);
        dataSource.setInitialSize(3);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);

        return dataSource;
    }
}


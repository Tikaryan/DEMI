package com.example.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



//Hibernate-mapping and Configuration File.......................................

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {	
	
	@Autowired
	Environment environment;
	
	private final String URL = "db.datasource.url";
	private final String USER = "db.datasource.username";
	private final String DRIVER = "db.datasource.driverClassName";
	private final String PASSWORD = "db.datasource.password";
	private String PACKAGES_TO_SCAN="entitymanager.packagesToScan";
	private String DIALECT="db.jpa.hibernate.dialect"; 
	private String SHOW_SQL="db.jpa.show-sql";
	private String FORMAT_SQL="db.jpa.format-sql";
/*	private String ENABLE_SECONDLEVEL_CACHE="db.enable.secondlevel_cache";
	private String ENABLE_QUERY_CACHE="db.enable.quer_cache";
	private String EHCACHE_CONFIG_RESOURCE="db.ehcache.configurationResourceName";
	private String CACHE_REGION_FACTORY="db.region.factory_class";
	private String CACHE_PROVIDER="db.cache.provider_class";*/

	@Bean
	DataSource dataSource() 
	{
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
		return driverManagerDataSource;
	}
	
	@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(environment.getProperty(PACKAGES_TO_SCAN));
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect",  environment.getProperty(DIALECT));
        hibernateProperties.put("hibernate.show_sql",   environment.getProperty(SHOW_SQL));
        hibernateProperties.put("hibernate.format_sql", environment.getProperty(FORMAT_SQL));
//        hibernateProperties.put("hibernate.cache.use_second_level_cache", environment.getProperty(ENABLE_SECONDLEVEL_CACHE));
//        hibernateProperties.put("hibernate.cache.use_query_cache", environment.getProperty(ENABLE_QUERY_CACHE));
//        hibernateProperties.put("net.sf.ehcache.configurationResourceName", environment.getProperty(EHCACHE_CONFIG_RESOURCE));
//        hibernateProperties.put("hibernate.cache.provider_class", environment.getProperty(CACHE_PROVIDER) );
//        hibernateProperties.put("hibernate.cache.region.factory_class", environment.getProperty(CACHE_REGION_FACTORY) );
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
 
	@Bean
    public HibernateTransactionManager transactionManager() {
    	HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
	
	
}

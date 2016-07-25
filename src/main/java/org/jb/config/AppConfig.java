package org.jb.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"org.jb.service","org.jb.data"})
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("org.jb.data.repository")
@PropertySource("classpath:application.properties")
public class AppConfig {
	
	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		String dbUrl = env.getRequiredProperty("db.url");
		if(StringUtils.contains(dbUrl, "DB_HOST_ENV_VAR")){
			dbUrl = dbUrl.replace("DB_HOST_ENV_VAR", env.getRequiredProperty(env.getRequiredProperty("DB_HOST_ENV_VAR")));
		}
		if(StringUtils.contains(dbUrl, "DB_PORT_ENV_VAR")){
			dbUrl = dbUrl.replace("DB_PORT_ENV_VAR", env.getRequiredProperty(env.getRequiredProperty("DB_PORT_ENV_VAR")));
		}
		System.out.println(dbUrl);
		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(env.getRequiredProperty("db.username"));
		dataSource.setPassword(env.getRequiredProperty("db.password"));
		return dataSource;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource());
		entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManager.setPackagesToScan("org.jb.data.model");
		entityManager.setJpaProperties(getHibernateProperties());
		return entityManager;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
	
	private Properties getHibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}
}

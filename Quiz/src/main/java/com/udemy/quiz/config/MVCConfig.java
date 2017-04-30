package com.udemy.quiz.config;
 
import javax.sql.DataSource;
 
import com.udemy.quiz.dao.UserInfoDAO;

//NEW
import com.udemy.quiz.dao.QuestionDAO;
import com.udemy.quiz.dao.impl.QuestionDAOImpl;

import com.udemy.quiz.dao.ResultsDAO;
import com.udemy.quiz.dao.impl.ResultsDAOImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Configuration
@ComponentScan("com.udemy.quiz.*")
@PropertySource("classpath:datasource-cfg.properties")
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private Environment env;
	 
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
		rb.setBasenames(new String[] { "messages/validator" });
		return rb;
	}
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// See: datasouce-cfg.properties for the details to link to database
		dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
		dataSource.setUrl(env.getProperty("ds.url"));
		dataSource.setUsername(env.getProperty("ds.username"));
		dataSource.setPassword(env.getProperty("ds.password"));
 
		System.out.println("## getDataSource: " + dataSource);
 
		return dataSource;
	}
  
	@Bean
	public QuestionDAO getQuestionDAO() {
		return new QuestionDAOImpl(getDataSource());
	}
	
	@Bean
	public ResultsDAO getResultsDAO() {
		return new ResultsDAOImpl(getDataSource());
	}
}
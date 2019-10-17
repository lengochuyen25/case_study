package com.codegym.casestudybookmanagerment;

import com.codegym.casestudybookmanagerment.formatter.AuthorFormatter;
import com.codegym.casestudybookmanagerment.service.AuthorService;
import com.codegym.casestudybookmanagerment.service.ProductService;
import com.codegym.casestudybookmanagerment.service.impl.AuthorServiceImpl;
import com.codegym.casestudybookmanagerment.service.impl.ProductServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class CasestudyBookmanagermentApplication {

	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(CasestudyBookmanagermentApplication.class, args);
	}

	@Bean
	public ProductService productService() {
		return new ProductServiceImpl() {
		};
	}

	@Bean
	public AuthorService authorService() {
		return new AuthorServiceImpl() {
		};

	}

}

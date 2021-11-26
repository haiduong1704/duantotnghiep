package com.fpoly;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class MockProjectT7Application {

	public static void main(String[] args) {
		SpringApplication.run(MockProjectT7Application.class, args);
	}
	
	@Configuration
	static class ApplicationSecurity extends WebSecurityConfigurerAdapter{
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/**");
		}
		
	}

}

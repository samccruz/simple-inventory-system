package com.sccruz.software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class InventoryBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryBootApplication.class, args);
	}
	
	@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages = "com.sccruz.software.inventory")
	public class DemoConfig extends WebMvcConfigurerAdapter{

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**");
		}
	}
}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	 	@Bean
//	    public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        CorsConfiguration config = new CorsConfiguration();
//	        config.setAllowCredentials(true);
//	        config.setAllowedOrigins(Collections.singletonList("*"));
//	        config.setAllowedMethods(Collections.singletonList("*"));
//	        config.setAllowedHeaders(Collections.singletonList("*"));
//	        source.registerCorsConfiguration("/**", config);
//	        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
//	        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//	        return bean;
//	    }
}

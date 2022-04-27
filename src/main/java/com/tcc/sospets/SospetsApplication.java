package com.tcc.sospets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class SospetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SospetsApplication.class, args);

		//try {
		//	Files.createDirectory(Paths.get("uploads"));
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
	}
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}

}

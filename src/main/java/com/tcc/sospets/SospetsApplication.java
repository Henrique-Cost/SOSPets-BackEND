package com.tcc.sospets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@SpringBootApplication
public class SospetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SospetsApplication.class, args);

		try {
		 	Files.createDirectory(Paths.get("uploads"));
		} catch (IOException e) {
			//e.printStackTrace();
			log.info("Aplicação rodando....");
		}
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

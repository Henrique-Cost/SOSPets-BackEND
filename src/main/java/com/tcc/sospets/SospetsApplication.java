package com.tcc.sospets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class SospetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SospetsApplication.class, args);
		try {
			Files.createDirectory(Paths.get("uploads"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

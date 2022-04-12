package com.tcc.sospets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


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

}

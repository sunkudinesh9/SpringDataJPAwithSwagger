package com.dineshlearnings.SpringDataJPAwithSwagger;

/**
 * @author sunku.dinesh9@gmail.com
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringDataJpAwithSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpAwithSwaggerApplication.class, args);
	}

}

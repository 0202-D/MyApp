package com.yourCodeReview.Dmitriy.Task1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
		Cache cache = new Cache();
		cache.put("One","Two");
		System.out.println(cache);
	}

}

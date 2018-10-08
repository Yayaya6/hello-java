package com.dimon.tryjava;

import com.dimon.tryjava.myAOP.springAOPDemo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloJavaApplication.class, args);
	}
}

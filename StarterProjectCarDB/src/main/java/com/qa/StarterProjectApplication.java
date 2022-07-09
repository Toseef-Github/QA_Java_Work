package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.controller.CarController;

@SpringBootApplication
public class StarterProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StarterProjectApplication.class, args);
        System.out.println("Found the bean: " + context.getBean(CarController.class));
    }

}
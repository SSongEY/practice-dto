package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@PropertySource("file:${C:\\workspaces\\__PrivProj\\devHistorySource\\DTO\\src\\main\\resources\\}/application.properties")
@SpringBootApplication
@EnableJpaAuditing
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}
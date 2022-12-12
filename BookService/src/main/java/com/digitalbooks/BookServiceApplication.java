package com.digitalbooks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@SpringBootApplication
public class BookServiceApplication 
{
public static void main(String[] args) 
{
SpringApplication.run(BookServiceApplication.class, args);
}
@Bean
public RestTemplate getRestTemplate() {
	return new RestTemplate();
}
}

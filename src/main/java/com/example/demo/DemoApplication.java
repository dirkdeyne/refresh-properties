package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "demo")
class MessageProperties {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

@Service
class MessageService {
	private final MessageProperties messageProperties;

	MessageService(MessageProperties messageProperties) {
		this.messageProperties = messageProperties;
	}

	public String message(){
		return messageProperties.getMessage();
	}
}

@RestController
class DemoController {

	private final MessageService messageService;

	public DemoController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping
	public String hello(){
		return messageService.message();
	}
}

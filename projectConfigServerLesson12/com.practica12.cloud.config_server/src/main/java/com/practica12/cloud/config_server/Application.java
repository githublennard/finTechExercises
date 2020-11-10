package com.practica12.cloud.config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableConfigServer
@Configuration

public class Application implements ErrorController {
	@Override
	@RequestMapping("/error")
	@ResponseBody

	public String getErrorPath() {
		return "No Mapping Found";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

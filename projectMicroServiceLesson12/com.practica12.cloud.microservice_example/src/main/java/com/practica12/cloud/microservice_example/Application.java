package com.practica12.cloud.microservice_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@RestController
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties(MyProps.class)
@RefreshScope

//@EnableEurekaClient

public class Application {

	@Autowired
	private Service service;

	@Autowired
	private MyProps props;

	@Value("${myprops.alias:alias!}")
	String alias;

	@Bean
	@RefreshScope
	public Service service()
	{
		return new Service();
		//return new Service(props.getName());
	}

	@RequestMapping("/")
	public String home()
	{
		return "Hello " + service.getName() + "!" + " with alias " + alias;
		//return "Hello World!";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

@Data
@RequiredArgsConstructor
class Service
{
	private final String name;

	//private Service()
	/*public Service()
	{
		name = "UNKNOWN";
	}*/
	Service()
	{
		name = "UNKNOWN";
	}


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}

@Data
@ConfigurationProperties("myprops")
class MyProps
{
	private String name = "World";

	public Object getName() {
		// TODO Auto-generated method stub
		//return null;
		return this.name;
	}
}


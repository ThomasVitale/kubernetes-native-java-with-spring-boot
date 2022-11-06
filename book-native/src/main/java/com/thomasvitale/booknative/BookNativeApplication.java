package com.thomasvitale.booknative;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
@ConfigurationPropertiesScan
public class BookNativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookNativeApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routerFunction(DemoProperties demoProperties) {
		return RouterFunctions.route()
			.GET("/", request -> ServerResponse.ok().bodyValue(demoProperties.message()))
			.GET("/books", request -> ServerResponse.ok().bodyValue(List.of(
				new Book("The Hobbit"),
				new Book("The Lord of the Rings"),
				new Book("His Dark Materials")
			)))
			.build();
	}

}

record Book(String title){}

@ConfigurationProperties(prefix = "demo")
record DemoProperties(String message){}

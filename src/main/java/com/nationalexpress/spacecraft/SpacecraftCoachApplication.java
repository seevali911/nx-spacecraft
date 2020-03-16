package com.nationalexpress.spacecraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SpacecraftCoachApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpacecraftCoachApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.nationalexpress"))
				.build()
				.apiInfo(apiInfoDetails());

	}


	private ApiInfo apiInfoDetails() {
		return new ApiInfo(
				"NX Spacecraft Coach Documentation",
				"APIs for accessing NX Spacecraft Coach service",
				"1.0",
				"Free for non-commercial use",
				new Contact("NX admin", "https://www.nationalexpress.com", "admin@nationalexpress.com"),
				"API License",
				"https://www.nationalexpress.com",
				Collections.emptyList());
	}


}

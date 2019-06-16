package com.webapp.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("RestAPI")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.webapp"))
				.paths(regex("/estudiantes.*"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Spring API REST")
				.description("REST API ejemplo con Spring 5")
				.version("0.1")
				.contact(new Contact("Jossue Fernández", "https://github.com/jossueF", "jossuefdez@gmail.com"))
				.build();
	}
}

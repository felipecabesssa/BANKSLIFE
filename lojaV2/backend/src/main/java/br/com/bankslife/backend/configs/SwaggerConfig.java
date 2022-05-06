package br.com.bankslife.backend.configs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Header;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	
	private final ResponseMessage m201 = customMessage1();
	private final ResponseMessage m204put = simpleMessage(204, "Atualização ok");
	private final ResponseMessage m204del = simpleMessage(204, "Deleção ok");
	private final ResponseMessage m403 = simpleMessage(403, "Não autorizado");
	private final ResponseMessage m404 = simpleMessage(404, "Não encontrado");
	private final ResponseMessage m422 = simpleMessage(422, "Erro de validação");
	private final ResponseMessage m500 = simpleMessage(500, "Erro inesperado");

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, Arrays.asList(m403, m404, m500))
				.globalResponseMessage(RequestMethod.POST, Arrays.asList(m201, m403, m422, m500))
				.globalResponseMessage(RequestMethod.PUT, Arrays.asList(m204put, m403, m404, m422, m500))
				.globalResponseMessage(RequestMethod.DELETE, Arrays.asList(m204del, m403, m404, m500))
				
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.bankslife.backend.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Backend do BANK$LIFE",
				"Este Backend é utilizado para Loja do BANK$LIFE",
				"Versão 1.0",
				"https://bankslife.com.br", //Termos de uso
				new Contact("Felipe Henrique", "https://bankslife.com.br", "felipesoares100@hotmail.com"), //Página de contato e email
				"Acesse nosso site para maiores informações alem da loja",
				"https://bankslife.com.br", 
				Collections.emptyList() // Vendor
																										// Extensions
		);
	}
	
	private ResponseMessage simpleMessage(int code, String msg) {
		return new ResponseMessageBuilder().code(code).message(msg).build();
	}
	
	private ResponseMessage customMessage1() {

		Map<String, Header> map = new HashMap<>();
		map.put("location", new Header("location", "URI do novo recurso", new ModelRef("string")));

		return new ResponseMessageBuilder()
		.code(201)
		.message("Recurso criado")
		.headersWithDescription(map)
		.build();
	}

}

package br.com.soc.tardelli.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket detailsApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.soc.tardelli.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informationsApi().build());

        return docket;
    }

    private ApiInfoBuilder informationsApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("SocApp - Pacientes");
        apiInfoBuilder.description("SocApp API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.licenseUrl("https://www.soc.com.br");

        return apiInfoBuilder;

    }
}

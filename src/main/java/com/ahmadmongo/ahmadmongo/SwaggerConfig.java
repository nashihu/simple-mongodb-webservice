package com.ahmadmongo.ahmadmongo;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(exceptErrorPaths())
                .build();
    }

    private Predicate<String> exceptErrorPaths() {
        return not(PathSelectors.regex("/error"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Jawaban soal testing ICON+")
                .description("Cek soalnya di url term of service")
                .termsOfServiceUrl("https://github.com/nashihu/simple-mongodb-webservice")
                .licenseUrl("github.com/nashihu")
                .contact(new Contact("Ahmad Nashihuddien", "", "ahmad.n.id@gmail.com"))
                .license("Mantap gan")
                .version("0.0.1")
                .build();
    }
}
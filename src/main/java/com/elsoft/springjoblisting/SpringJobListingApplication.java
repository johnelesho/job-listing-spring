package com.elsoft.springjoblisting;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.net.URL;

@SpringBootApplication
@EnableSwagger2
@RestController
public class SpringJobListingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJobListingApplication.class, args);
    }

    @ApiIgnore
    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("swagger-ui.html");
    }
    @Bean
    public Docket swagger(){
        return new Docket(
                DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()).useDefaultResponseMessages(false);

    }

    @Bean
    public ApiInfo   apiInfo() {
        return new ApiInfo(
                "Spring Job Listing Api",
                "An API to manage Job listings",
                "1.0",
                "wwww.elsoft.com",
                "John Elesho",
                "",
                ""
        );
    }

}

package com.mindtree.table.reservation.swagger;

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

/**
 * @author Ranjith Ranganathan
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket restaurantApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("com.mindtree.table.reservation"))
            .paths(PathSelectors.ant("/*")).build().apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        ApiInfoBuilder builder = new ApiInfoBuilder();
        Contact contact = new Contact("Ranjith Ranganathan", "https://www.mindtree.com/",
            "ranjith.ranganathan@mindtree.com");
        ApiInfo apiInfo = builder.contact(contact).description("APIs for reserving a table in a hotel")
            .license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
            .version("1.0").title("Online Table Reservation System API").build();
        return apiInfo;
    }
}

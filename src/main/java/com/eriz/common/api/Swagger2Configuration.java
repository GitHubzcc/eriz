package com.eriz.common.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;

/**
 * <p>
 *     swagger2 config
 * </p>
 * 2019年1月9日 | eriz
 */
@Configuration
public class Swagger2Configuration {

    @Resource
    private SwaggerPropertis swaggerPropertis;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.eriz"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerPropertis.getTitle())
                .description(swaggerPropertis.getDescription())
                .termsOfServiceUrl(swaggerPropertis.getTermsOfServiceUrl())
                .version(swaggerPropertis.getVersion())
                .build();
    }

}

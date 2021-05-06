package br.com.dio.eskpicpayclone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Value("${spring.api.version}")
    private String versionApplication;

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("br.com.dio.eskpicpayclone"))
                .paths(PathSelectors.any()).build()
                .apiInfo(apiInfo()).useDefaultResponseMessages(false);
    }

    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Esk PicPayClone API")
                .description("Estrutura de uma API RestFull com Spring Boot para simular funcionalidades do PicPay")
                .version(versionApplication).build();
   }

}

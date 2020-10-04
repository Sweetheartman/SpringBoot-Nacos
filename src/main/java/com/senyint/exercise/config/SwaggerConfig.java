package com.senyint.exercise.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: springboot-shiro-combat
 * @description: swagger2的配置类
 * @author: lidekun
 * @create: 2020-08-22 11:46
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.enable}")
    private boolean enable;
    @Bean
    public Docket createDocket(){
        /**
         * 这是为了我们在用 swagger 测试接口的时候添加头部信息
         */
        List<Parameter> pars = new ArrayList<Parameter>();
        ParameterBuilder accessTokenBuilder = new ParameterBuilder();
        ParameterBuilder refreshTokenBuilder = new ParameterBuilder();
        accessTokenBuilder.name("accessToken")
                .description("请求访问令牌accessToken")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false);

        refreshTokenBuilder.name("refreshToken")
                .description("请求刷新访问令牌refreshToken")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false);
        /**
         * 多个的时候 就直接添加到 pars 就可以了
         */
        pars.add(accessTokenBuilder.build());
        pars.add(refreshTokenBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.senyint.exercise.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .enable(enable)
                ;
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().
                title("Spring Boot 2.1.6")
                .description("spring boot 2.1.6")
                .version("1.0")
                .build();
    }
}

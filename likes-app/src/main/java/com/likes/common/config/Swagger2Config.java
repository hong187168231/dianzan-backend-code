package com.likes.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableKnife4j
@EnableOpenApi
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {

        AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] scopeArray = {scope};
        //存储令牌和作用域
        SecurityReference reference = new SecurityReference("authorization", scopeArray);
        List refList = new ArrayList();
        refList.add(reference);
        SecurityContext context = SecurityContext.builder().securityReferences(refList).build();

        List cxtList = new ArrayList();
        cxtList.add(context);

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.likes"))  //设置扫描 swagger的注解包路径 所有的需要用swagger显示的
                .build()
                .securitySchemes(Collections.singletonList(HttpAuthenticationScheme.
                        JWT_BEARER_BUILDER.name("authorization").build()))
                .securityContexts(Collections.singletonList(SecurityContext.builder()
                                .securityReferences(Collections.singletonList(SecurityReference.builder()
                                        .scopes(new AuthorizationScope[0])
                                        .reference("authorization")
                                        .build()))
                                .operationSelector(o -> o.requestMappingPattern().matches("/.*"))
                                .build()
                        )
                );

    }


    // 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题1
                .title("点赞RESTful API")
                // 描述
                .description("点赞平台").termsOfServiceUrl("http://localhost:5859/")
                // 创建人
                .contact(new Contact("Presoft", "http://www.baidu.com", ""))
                // 版本号
                .version("1.0.1").build();
    }
}
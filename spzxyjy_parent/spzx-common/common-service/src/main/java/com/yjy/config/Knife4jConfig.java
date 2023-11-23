package com.yjy.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//Knife4j是一种基于Swagger构建的增强工具,可以根据Java代码中的注解自动生成API接口文档
@Configuration
public class Knife4jConfig {
    @Bean
    public GroupedOpenApi adminApi() {      // 创建了一个api接口的分组
        return GroupedOpenApi.builder()
                .group("admin-api")         // 分组名称
                .pathsToMatch("/admin/**")  // 接口请求路径规则
                .build();
    }
    /***
     * @description 自定义接口信息
     */
    @Bean
    public OpenAPI customOpenAPI() {
        //链式调用，方法返回的是调用它的对象本身
        return new OpenAPI()
                .info(new Info()
                        .title("尚品甑选API接口文档")
                        .version("1.0")
                        .description("尚品甑选API接口文档")
                        .contact(new Contact().name("yjy"))); // 设定作者
    }

}

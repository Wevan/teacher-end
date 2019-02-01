package com.nuc.tracking.teacherend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.PathSelectors.regex
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.ApiKey
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.SecurityReference
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.text.SimpleDateFormat
import java.util.*

/**
 * @author 杨晓辉 2018/2/1 14:28
 *
 * 用于生成文档页面
 *
 * [swagger页面](api://localhost:8082/swagger-ui.html)
 *
 */
@Configuration
@EnableSwagger2
class SwaggerConfig {

    /**
     * swagger2 的配置
     */
    @Bean
    fun createRestApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.nuc.tracking.teacherend.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .securitySchemes(Arrays.asList(
                        ApiKey(
                                "Bearer %token",
                                "Authorization",
                                "Header"
                        )
                ))
    }

    private fun apiInfo(): ApiInfo {
        val date = Date()
        val formattedDate = SimpleDateFormat("yyMMddHH")
        return ApiInfoBuilder()
            .title("学习过程跟踪评价系统")
            .description("新工科在线教育平台-评价模块")
            .version(formattedDate.format(date))
            .build()
    }

    private fun securitySchemes(): List<ApiKey> {
        val apiKeyList = ArrayList<ApiKey>()
        apiKeyList.add(ApiKey("x-auth-token", "x-auth-token", "header"))
        return apiKeyList
    }

    private fun securityContexts(): List<SecurityContext> {
        val securityContexts = ArrayList<SecurityContext>()
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build())
        return securityContexts
    }

    internal fun defaultAuth(): List<SecurityReference> {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes = arrayOfNulls<AuthorizationScope>(1)
        authorizationScopes[0] = authorizationScope
        val securityReferences = ArrayList<SecurityReference>()
        securityReferences.add(SecurityReference("Authorization", authorizationScopes))
        return securityReferences
    }

}

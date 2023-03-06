package com.simplework.simplework.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private static List<String> allowedOriginPatterns = List.of(new String[]{"Access-Control-Allow-Origin"});

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        设置允许跨域的路径
        registry.addMapping("/**")
//                设置允许跨域请求的域名
                .allowedOriginPatterns("*")
//                是否允许证书
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT","OPTIONS")
                .allowedHeaders("*")
//                跨域允许时间
                .maxAge(3600);
    }
}
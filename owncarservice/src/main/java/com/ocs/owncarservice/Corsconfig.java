package com.ocs.owncarservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ConfigurationProperties
public class Corsconfig implements WebMvcConfigurer {

                @Override
                public void addCorsMappings(CorsRegistry registry) {
                                registry.addMapping("/**");
                }
                @Bean
                public FilterRegistrationBean<CorsFilter> corsFilter() {
                                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                                CorsConfiguration config = new CorsConfiguration();
                                config.setAllowCredentials(true);
                                config.addAllowedOrigin("*");
                                config.addExposedHeader("Authorization, x-xsrf-token, Access-Control-Allow-Headers,Token, Origin, Accept, X-Requested-With, " +
                                        "Content-Type, Access-Control-Request-Method, Custom-Filter-Header");
                                config.addAllowedHeader("*");
                                config.addAllowedMethod("OPTIONS");
                                config.addAllowedMethod("HEAD");
                                config.addAllowedMethod("GET");
                                config.addAllowedMethod("PUT");
                                config.addAllowedMethod("POST");
                                config.addAllowedMethod("DELETE");
                                config.addAllowedMethod("PATCH");
                                source.registerCorsConfiguration("/**", config);
                                final FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
                                bean.setOrder(0);
                                return bean;
                }
                
                
                
}


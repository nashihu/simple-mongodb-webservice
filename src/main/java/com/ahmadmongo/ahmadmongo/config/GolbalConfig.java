//package com.ahmadmongo.ahmadmongo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.concurrent.Executor;
//
//@Configuration
//@EnableAsync
//public class GolbalConfig {
//    /* enable cors for all controller*/
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
//                        .allowedOrigins("*")
//                        .allowCredentials(true)
//                        .maxAge(3600)
//                        .allowedHeaders("X-Requested-With", "Content-Type", "Authorization", "Origin", "Accept", "Access-Control-Request-Method", "Access-Control-Request-Headers");
//            }
//        };
//    }
//
//    @Bean(name = "jwtFilterRequest")
//    public JwtFilter jwtFilterRequest() {
//        return new JwtFilter();
//    }
//
//    @Bean(name = "threadPoolExecutor")
//    public Executor taskExecutor2() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setMaxPoolSize(10);
//        executor.initialize();
//        executor.setThreadNamePrefix("threadPoolExecutor-");
//        return executor;
//    }
//}
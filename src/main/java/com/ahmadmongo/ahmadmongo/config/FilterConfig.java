//package com.ahmadmongo.ahmadmongo.config;
//
//import com.ahmadmongo.ahmadmongo.repo.SysUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//    private static final String JWT_FILTER = "jwtFilter";
//    @Autowired
//    private SysUserRepository authRepository;
//    @Autowired
//    private JwtFilter jwtFilter;
//
//    @Bean(name = JWT_FILTER)
//    public FilterRegistrationBean jwtFilter() {
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(jwtFilter);
//        registrationBean.addUrlPatterns("/master/*");
//
//        return registrationBean;
//    }
//}

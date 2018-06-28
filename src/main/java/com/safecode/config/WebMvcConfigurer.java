//package com.safecode.config;
//
///*
// springboot拦截器全局配置
// */
//
//import com.safecode.interceptor.LoginInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
//
//    @Autowired
//    LoginInterceptor LoginInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(LoginInterceptor).addPathPatterns("/**").
//                excludePathPatterns("/login.html", "/registered.html","/pages/Amberhtml/**","/user/login","/user/mail","/user/register","/user/publish","/user/aid");//PathPatterns为过滤的url路径,excludePathPatterns不拦截的url路径多个路径用逗号隔开
//        super.addInterceptors(registry);
//    }
//}

package com.safecode.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    LoginInterceptor kk() {
        return new LoginInterceptor();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("Interceptor1 start work-访问拦截");
        System.out.println("请求路径是:" + "   " + request.getRequestURI());
        System.out.println("session的名字" + request.getSession().getAttribute("user"));
        if (request.getSession().getAttribute("user") != null) {
            System.out.println("session不为空");
            return true;
        } else {
            System.out.println("?????????????");
            response.sendRedirect("/login.html");
            return false;
        }
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)  {
//        System.out.println("Interceptor1 before return view");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  {
//        System.out.println("Interceptor1 finish work");
//    }
}

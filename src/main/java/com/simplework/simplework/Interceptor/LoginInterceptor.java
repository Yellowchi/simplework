package com.simplework.simplework.Interceptor;

import com.simplework.simplework.Mapper.HistRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private HistRequestMapper histRequestMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("prehandle："+request+"||||"+response+"||||"+handler);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("aftercompletion");
//        String requestpath = request.getServletPath().replace("/api", "");
//        HistRequest histRequest = new HistRequest();
//        histRequest.setRequestpath(requestpath);
//        histRequest.setSessionid(request.getSession().getId());
//        histRequest.setRequestdate(new Date());
//        histRequestMapper.insert(histRequest);
    }
    // mapper指向空解决办法： https://www.jianshu.com/p/6b07af556922
}

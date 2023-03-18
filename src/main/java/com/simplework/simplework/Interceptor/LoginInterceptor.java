package com.simplework.simplework.Interceptor;

import com.simplework.simplework.Bean.HistRequest;
import com.simplework.simplework.Mapper.HistRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private HistRequestMapper histRequestMapper;

    private String sessionid;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("prehandle："+request+"||||"+response+"||||"+handler);
        this.sessionid = request.getSession().getId();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("aftercompletion");
        String requestpath = request.getServletPath().replace("/api", "");
        HistRequest histRequest = new HistRequest();
        histRequest.setRequestpath(requestpath);
        histRequest.setSessionid(sessionid);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(System.currentTimeMillis());
        System.out.println(format);

        histRequestMapper.insert(histRequest);
    }
    // mapper指向空解决办法： https://www.jianshu.com/p/6b07af556922
}

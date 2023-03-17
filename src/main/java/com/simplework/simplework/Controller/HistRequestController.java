package com.simplework.simplework.Controller;

import com.simplework.simplework.Bean.HistRequest;
import com.simplework.simplework.Mapper.HistRequestMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/histrequest")
public class HistRequestController {
    @Resource
    private HistRequestMapper histRequestMapper;
    @GetMapping("/record")
    public void record(HttpServletRequest request){
        String requestpath = request.getServletPath().replace("/api", "");
        HistRequest histRequest = new HistRequest();
        histRequest.setRequestpath(requestpath);
        histRequest.setSessionid(request.getSession().getId());
//        histRequest.setRequestdate(new Date().toString());
        histRequestMapper.insert(histRequest);
    }
}

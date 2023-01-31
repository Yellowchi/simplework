package com.simplework.simplework.Controller;

import com.simplework.simplework.Bean.Stuinfo;
import com.simplework.simplework.Bean.Test;
import com.simplework.simplework.Repository.StuinfoRepository;
import com.simplework.simplework.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/thymetest")
@EnableAutoConfiguration
public class ThymeTestController {
    @Autowired
    private TestRepository testRepository;
    @GetMapping()
    public String enter(){
        return "main";
    }
    @GetMapping("/test")
    public String test(Model model){
        List<Test> test;
        test = testRepository.findAll();
        model.addAttribute("test",test);
        return "main";
    }
    @Autowired
    private StuinfoRepository stuinfoRepository;
    @GetMapping("/stuinfo")
    public String stuinfo(Model model){
        List<Stuinfo> stuinfo;
        stuinfo = stuinfoRepository.findAll();
        model.addAttribute("stuinfo",stuinfo);
        return "main";
    }
}

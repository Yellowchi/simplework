package com.simplework.simplework.Controller;

import com.simplework.simplework.Bean.Test;
import com.simplework.simplework.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestRepository testRepository;
    @PostMapping()
    public void addtest(@RequestParam("user") String user,@RequestParam("password") String password){
        Test test = new Test();
        test.setUser(user);
        test.setPassword(password);
        testRepository.save(test);
        /*return testRepository.save(test);*/
    }
    @GetMapping("/list")
    public List<Test> searchall(){
        return testRepository.findAll();
    }

}

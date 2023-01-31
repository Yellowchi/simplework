package com.simplework.simplework.Controller;

import com.simplework.simplework.Bean.Job;
import com.simplework.simplework.Bean.Simpletalk;
import com.simplework.simplework.Service.BussinfoService;
import com.simplework.simplework.Service.JobService;
import com.simplework.simplework.Service.SimpletalkService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/job")
public class JobController {
    @Resource
    private JobService jobService;
    @Resource
    private BussinfoService bussinfoService;
    @Resource SimpletalkService simpletalkService;
    @GetMapping()
    public List<Job> findall(){
        return jobService.findAll();
    }
    //如果用jpa查询Time类型，可以在Controller导入String，在调用JPA接口时，将String类型通过Time.valueOf(String)转换成Time类型才能查询
    //为什么不能直接用String来查询呢？？？？？
    @GetMapping("/jobin8")
    public List<Job> findallin8(){
        String start = "08:00:00";
        String end = "10:00:00";
        return jobService.findByJobstartBetween(start,end);
    }
    @GetMapping("/jobin10")
    public List<Job> findallin10(){
        String start = "10:00:00";
        String end = "12:00:00";
        return jobService.findByJobstartBetween(start,end);
    }
    @GetMapping("/jobin13")
    public List<Job> findallin12(){
        String start = "13:00:00";
        String end = "15:00:00";
        return jobService.findByJobstartBetween(start,end);
    }
    @GetMapping("/jobin15")
    public List<Job> findallin14(){
        String start = "15:00:00";
        String end = "17:00:00";
        return jobService.findByJobstartBetween(start,end);
    }
    @GetMapping("/jobin18")
    public List<Job> findallin18(){
        String start = "18:00:00";
        String end = "22:00:00";
        return jobService.findByJobstartBetween(start,end);
    }
    @GetMapping("/search/{search}")
    public List<Job> searchjob(@PathVariable("search") String search){
        return jobService.findalllike(search);
    }
    @GetMapping("/findid/{jobid}")
    public Job findbyid(@PathVariable("jobid") int jobid){
        return jobService.findByJobid(jobid);
    }
    @GetMapping("/findbussname/{jobid}")
    public String findbussnamebyjobid(@PathVariable("jobid")int jobid){
        String bussid =  jobService.findbussidbyjobid(jobid);
        return bussinfoService.findbussnamebybussid(bussid);
    }
    @GetMapping("/findtalk/{jobid}")
    public List<Simpletalk> findtalkbyjobid(@PathVariable("jobid") int jobid){
        return simpletalkService.findallbyjobid(jobid);
    }
}

package com.simplework.simplework.Controller;

import com.simplework.simplework.Bean.Resumes;
import com.simplework.simplework.Service.ResumesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
    @Resource
    private ResumesService resumesService;
    @GetMapping("/send/{stuid}/{jobid}")
    public void sendResumes(@PathVariable("stuid") String stuid,@PathVariable("jobid") int jobid){
        Resumes resumes = new Resumes();
        resumes.setStuid(stuid);
        resumes.setJobid(jobid);
        resumes.setState("等待中");
        resumesService.insertResumes(resumes);
    }
    @GetMapping("/get/{stuid}")
    public List<Resumes> getResumestrace(@PathVariable("stuid") String stuid){
        return resumesService.getresumestrace(stuid);
    }
}

package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Job;
import com.simplework.simplework.Repository.JobRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service

public class JobServiceImpl implements JobService{
    @Resource
    private JobRepository jobRepository;
    @Override
    public Job insertJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public void deleteJob(Integer jobid) {
        jobRepository.deleteById(jobid);
    }

    @Override
    public Job updateJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findBybussid(Integer bussid) {
        return jobRepository.findByBussid(bussid);
    }

    @Override
    public List<Job> findByJobstartBetween(String start, String end) {
        return jobRepository.findByJobstartBetween(Time.valueOf(start),Time.valueOf(end));
    }

    @Override
    public List<Job> findalllike(String search) {
        String searchcontext = "%"+search+"%";
        return jobRepository.findByJobnameLike(searchcontext);
    }

    @Override
    public Job findByJobid(int jobid) {
        return jobRepository.findByJobid(jobid);
    }

    @Override
    public String findbussidbyjobid(int jobid) {
        return jobRepository.findBussidByJobid(jobid);
    }
}

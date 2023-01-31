package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {
    /**
     * 新增
     */
    Job insertJob(Job job);

    /**
     * 删除
     */
    void deleteJob(Integer jobid);

    /**
     * 修改
     */
    Job updateJob(Job job);

    /**
     * 查询所有
     */
    List<Job> findAll();

    /**
     * 查询某一个根据bussid
     */
    Job findBybussid(Integer bussid);

    List<Job> findByJobstartBetween(String start, String end);

    List<Job> findalllike(String search);

    Job findByJobid(int jobid);

    String findbussidbyjobid(int jobid);
}

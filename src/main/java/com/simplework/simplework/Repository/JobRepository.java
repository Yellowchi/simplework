package com.simplework.simplework.Repository;

import com.simplework.simplework.Bean.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface JobRepository extends JpaRepository<Job,Integer> {
    Job findByBussid(Integer bussid);
    
    List<Job> findByJobstartBetween(Time start, Time end);

    List<Job> findByJobnameLike(String search);

    Job findByJobid(int jobid);

    @Query("select bussid from Job where jobid = ?1")
    String findBussidByJobid(int jobid);
}

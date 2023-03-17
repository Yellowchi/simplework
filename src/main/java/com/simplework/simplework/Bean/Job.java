package com.simplework.simplework.Bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Time;

@Table(name="job")
@Data
@ToString
@Component
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Job {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id
    @TableId
    @Column(name="jobid")
    private int jobid;
    @Column(name = "bussid")
    private String bussid;
    @Column(name = "jobname")
    private String jobname;
    @Column(name = "jobselery")
    private String jobselery;
    @Column(name="jobstart")
    private Time jobstart;
    @Column(name = "joblast")
    private String joblast;
    @Column(name = "jobaddress")
    private String jobaddress;
    @Column(name = "jobinfo")
    private String jobinfo;
    @Column(name = "createdate")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String createdate;
}

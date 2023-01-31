package com.simplework.simplework.Bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name="bussinfo")
@Data
@ToString
@Component
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Bussinfo {
    @Id
    private String bussid;
    private String password;
    private String bussname;
    private String bussinfo;
    private String bussplace;
    private String empname;
    private int tel;
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdate;

    @OneToMany
    @TableField(exist = false)
    private List<Job> jobs;

}

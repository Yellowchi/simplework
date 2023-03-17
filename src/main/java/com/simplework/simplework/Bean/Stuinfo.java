package com.simplework.simplework.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Table(name="stuinfo")
@Data
@ToString
@Component
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Stuinfo {
    @Id
    @TableId(type = IdType.INPUT,value = "stuid")
    @Column(name = "stuid")
    private String stuid;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "age")
    private int age;
    @Column(name = "stuno")
    private int stuno;
    @Column(name = "bussname")
    private String bussname;
    @Column(name = "bussid")
    private String bussid;
    @Column(name = "email")
    private String email;
    @Column(name = "tel")
    private String tel;
    @Column(name = "createdate")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdate;

}

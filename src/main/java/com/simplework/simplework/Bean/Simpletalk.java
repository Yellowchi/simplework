package com.simplework.simplework.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Table(name="simpletalk")
@Data
@ToString
@Component
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Simpletalk {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int simpletalkid;
    private String simpletalkname;
    @CreatedBy
    @LastModifiedBy
    private String author;
    private String authorid;
    private String item;
    private int jobid;
    private String text;
    private int agress;
    private int transpond;
    private int comment;
    @CreatedDate
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
}

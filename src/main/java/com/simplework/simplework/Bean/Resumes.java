package com.simplework.simplework.Bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Table(name="resumes")
@Data
@ToString
@Component
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Resumes {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int resumesid;
    @Column(name = "stuid")
    private String stuid;
    private int jobid;
    private String state;
}

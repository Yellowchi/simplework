package com.simplework.simplework.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Table(name="comment")
@Data
@ToString
@Component
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Comment {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int commentid;
    private int simpletalkid;
    private String com_content;
    private int com_agress;
    private int com_disagress;
    private String id;
    private String name;
    private String item;
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
}

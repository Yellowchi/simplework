package com.simplework.simplework.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Table(name="chat")
@Data
@ToString
@Component
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Chat {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int chatid;
    private String content;
    @Column(name = "sendid")
    private String sendid;
    @Column(name = "toid")
    private String toid;
    private String senditem;
    private String toitem;
    @Column(name = "time")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;
}

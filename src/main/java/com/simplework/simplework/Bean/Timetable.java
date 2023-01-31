package com.simplework.simplework.Bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Time;

@Table(name="timetable")
@Data
@ToString
@Component
@Entity
@EntityListeners(AuditingEntityListener.class)

public class Timetable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int timetableid;
    private String course;
    private String starttime;
    private String endtime;
    private String day;
    private int stuid;
}

package com.simplework.simplework.Bean;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Table(name= "hist_request")
@Data
@ToString
@Component
@Entity
@EntityListeners(AuditingEntityListener.class)
public class HistRequest {
    @Id
    @TableId(value = "histrequestid",type = IdType.INPUT)
    private Integer histrequestid;
    @Column(name = "requestpath")
    private String requestpath;
    @Column(name = "sessionid")
    private String sessionid;
    @TableField(value = "requestdate" , fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date requestdate;
}

package com.simplework.simplework.Bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@ToString
@Entity
@Component
public class User {
    @Id
    @TableId
    private String user;
    private String password;
    private boolean state;
}

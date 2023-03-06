package com.simplework.simplework.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simplework.simplework.Bean.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where user = #{user}")
    public User selectbyuser(String user);
}

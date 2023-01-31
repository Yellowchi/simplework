package com.simplework.simplework.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simplework.simplework.Bean.Bussinfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BussinfoMapper extends BaseMapper {
    @Select("select * from bussinfo where bussid = #{bussid}")
    @Results({
            @Result(column = "bussid",property = "bussid"),
            @Result(column = "password",property = "password"),
            @Result(column = "bussname",property = "bussname"),
            @Result(column = "bussinfo",property = "bussinfo"),
            @Result(column = "bussplace",property = "bussplace"),
            @Result(column = "empname",property = "empname"),
            @Result(column = "tel",property = "tel"),
            @Result(column = "createdate",property = "createdate"),
            @Result(column = "bussid",property = "jobs",javaType = List.class,
            many = @Many(select = "com.simplework.simplework.Mapper.JobMapper.selectbybussid"))
    })
    List<Bussinfo> selectbussinfobybussidandjobs(String bussid);
}

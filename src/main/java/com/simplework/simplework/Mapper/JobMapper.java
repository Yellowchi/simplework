package com.simplework.simplework.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simplework.simplework.Bean.Job;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JobMapper extends BaseMapper<Job> {
    @Select("select * from job where bussid = #{bussid}")
    List<Job> selectbybussid(String bussid);

    @Select("delete form job where jobid = #{jobid}")
    void  deletebyjobid(int jobid);
}

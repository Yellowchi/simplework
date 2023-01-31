package com.simplework.simplework.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simplework.simplework.Bean.Job;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JobMapper extends BaseMapper {
    @Select("select * from job where bussid = #{bussid}")
    List<Job> selectbybussid(String bussid);
}

package com.simplework.simplework.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simplework.simplework.Bean.Simpletalk;
import org.apache.ibatis.annotations.Select;

public interface SimpletalkMapper extends BaseMapper<Simpletalk> {
    @Select("delete from simpletalk where simpletalkid = #{simpletalkid}")
    void deletebysimpletalkid(int simpletalkid);
}

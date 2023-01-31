package com.simplework.simplework.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.simplework.simplework.Bean.Stuinfo;

public interface StuinfoMapper extends BaseMapper<Stuinfo> {

//mybatis
//    @Select("select * from stuinfo where stuid = #{stuid}")
//    public Stuinfo findbystuid(int stuid);
    /*mybatis中，对于一对多的关联查找，用many = @Many（）
    对于一对一的关联查找，用one = @One（）
    对于结果
    @Results({
        @Result(column = 列名，property = 数据库中名字)
        @Result(column = 要用到的属性,property = 关联实体,javaType = List.class,
         many = @Many(其他Mapper中的方法)
         )
        @Result(column = 要用到的属性,property = 关联实体,javaType = 关联实体.class
         one = @One(其他Mapper中的方法)
         )
    })
     */
}

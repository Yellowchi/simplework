package com.simplework.simplework.Handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * @author wjs
 * @description 新增与修改数据时自动生成时间戳
 * @date 2022-08-22 16:56
 */
// 将实现类注入到springboot容器中
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // createTime 这个字段与pojo类中字段对应
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("requestdate",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);
    }
}


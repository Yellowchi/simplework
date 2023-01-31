package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Chat;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChatService {
    /**
     * 新增
     */
    Chat insertchat(Chat chat);
    /**
     * 查询
     */
    List<Chat> findAll();
    /**
     * 根据sendid和toid寻找交流
     * id1是我的id，id2是对方id
     */
    List<Chat> findAllbysendidandtoid(String id1,String id2);

    List<Chat> findallbytoid(String id);

    List<Chat> findallbysendid(String id);
}

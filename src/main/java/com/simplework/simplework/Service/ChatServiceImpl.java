package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Chat;
import com.simplework.simplework.Repository.ChatRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ChatServiceImpl implements ChatService {
    @Resource
    private ChatRepository chatRepository;

    @Override
    public Chat insertchat(Chat chat){
        return chatRepository.saveAndFlush(chat);
    }

    @Override
    public List<Chat> findAll(){
        return chatRepository.findAll();
    }

    @Override
    public List<Chat> findAllbysendidandtoid(String id1,String id2){
        return chatRepository.findallbysendidandtoidorder(id1,id2);
    }

    @Override
    public List<Chat> findallbytoidtoitem(String id,String item) {
        return chatRepository.findByToidAndToitem(id,item);
    }

    @Override
    public List<Chat> findallbysendidsenditem(String id,String item) {
        return chatRepository.findBySendidAndSenditem(id,item);
    }
}

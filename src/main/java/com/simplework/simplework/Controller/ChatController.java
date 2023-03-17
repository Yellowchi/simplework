package com.simplework.simplework.Controller;


import com.simplework.simplework.Bean.Chat;
import com.simplework.simplework.Service.ChatService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Resource
    private ChatService chatService;
    @GetMapping("/getallaboutme/{id}/{item}")
    public List<Chat> getallaboutme(@PathVariable("id")String id,@PathVariable("item")String item){
        List<Chat> chatList1 = chatService.findallbytoidtoitem(id,item);
        List<Chat> chatList2 = chatService.findallbysendidsenditem(id,item);
        chatList1.addAll(chatList2);
        return chatList1;
    }
    @GetMapping("/talkwith/{myid}/{withid}")
    public List<Chat> gettalkwith(@PathVariable("myid") String myid,@PathVariable("withid") String withid){
        return chatService.findAllbysendidandtoid(myid,withid);
    }
    @PostMapping("/send")
    public void sendchat(@RequestBody Chat chat){
        chatService.insertchat(chat);
    }
}

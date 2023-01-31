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
    @GetMapping("/getallaboutme/{id}")
    public List<Chat> getallaboutme(@PathVariable("id")String id){
        List<Chat> chatList1 = chatService.findallbytoid(id);
        List<Chat> chatList2 = chatService.findallbysendid(id);
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

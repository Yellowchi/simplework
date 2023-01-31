package com.simplework.simplework.Controller;


import com.simplework.simplework.Bean.Bussinfo;
import com.simplework.simplework.Bean.Comment;
import com.simplework.simplework.Bean.Stuinfo;
import com.simplework.simplework.Service.BussinfoService;
import com.simplework.simplework.Service.CommentService;
import com.simplework.simplework.Service.StuinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Resource
    private CommentService commentService;
    @Resource
    private StuinfoService stuinfoService;
    @Resource
    private BussinfoService bussinfoService;
    @GetMapping("/simpletalkid/{simpletalkid}")
    public List<Comment> findallbysimpletalkid(@PathVariable("simpletalkid")int simpletalkid){
        return commentService.findBysimpletalkid(simpletalkid);
    }
    @PostMapping("/add")
    public void addcomment(@RequestBody Comment comment){
        if(comment.getItem().equals("stu")){
            Stuinfo stuinfo = stuinfoService.findBystuid(comment.getId());
            comment.setName(stuinfo.getUsername());
        }else{
            Bussinfo bussinfo = bussinfoService.findBybussid(comment.getId());
            comment.setName(bussinfo.getBussname());
        }
        commentService.insertComment(comment);
    }
}

package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Comment;

import java.util.List;

public interface CommentService {
    /**
     * 新增
     */
    Comment insertComment(Comment comment);
    /**
     * 删除
     */
    void deleteComment(Integer commentid);
    /**
     * 修改
     */
    Comment updateComment(Comment comment);
    /**
     * 查询所有
     */
    List<Comment> findAll();
    /**
     * 查询某一个根据simpletalkid
     */
    List<Comment> findBysimpletalkid(Integer stid);
}

package com.simplework.simplework.Service;

import com.simplework.simplework.Bean.Comment;
import com.simplework.simplework.Repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class CommentServiceImpl implements CommentService{
    @Resource
    private CommentRepository commentRepository;
    @Override
    public Comment insertComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Integer commentid) {
        commentRepository.deleteById(commentid);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findBysimpletalkid(Integer stid) {
        return commentRepository.findBySimpletalkid(stid);
    }
}

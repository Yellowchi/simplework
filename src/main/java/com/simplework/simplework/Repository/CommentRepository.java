package com.simplework.simplework.Repository;

import com.simplework.simplework.Bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findBySimpletalkid(Integer stid);
}

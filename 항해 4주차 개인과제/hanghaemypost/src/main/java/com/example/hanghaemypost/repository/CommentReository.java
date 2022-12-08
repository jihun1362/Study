package com.example.hanghaemypost.repository;

import com.example.hanghaemypost.entity.Comment;
import com.example.hanghaemypost.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentReository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostOrderByCreatedAtDesc(Post post);
}

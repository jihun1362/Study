package com.example.hanghaemypost.service;

import com.example.hanghaemypost.Jwt.JwtUtil;
import com.example.hanghaemypost.entity.Comment;
import com.example.hanghaemypost.entity.Post;
import com.example.hanghaemypost.entity.User;
import com.example.hanghaemypost.entity.UserRoleEnum;
import com.example.hanghaemypost.repository.CommentReository;
import com.example.hanghaemypost.repository.PostRepository;
import com.example.hanghaemypost.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EffectivenessCheck {
    private final JwtUtil jwtUtil;
    private final CommentReository commentReository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;


    public User userAndTokenCheck(String token) {
        Claims claims;
        if (jwtUtil.validateToken(token)) {
            claims = jwtUtil.getUserInfoFromToken(token);
        } else throw new IllegalArgumentException("토큰이 유효하지 않습니다.");

        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("사용자가 존재하지 않습니다!")
        );
        return user;
    }

    public Post postCheck(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다!")
        );
        return post;
    }

    public void postRoleCheck(User user, Post post) {
        if (user.getRole() == UserRoleEnum.USER) {
            if (!post.getUser().getUsername().equals(user.getUsername())) {
                throw new IllegalArgumentException("관리자와 작성자만 수정할 수 있습니다!");
            }
        }
    }

    public Comment commentCheck(Long id) {
        Comment comment = commentReository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다!")
        );
        return comment;
    }

    public void commentRoleCheck(User user, Comment comment) {
        if (user.getRole() == UserRoleEnum.USER) {
            if (!comment.getUser().getUsername().equals(user.getUsername())) {
                throw new IllegalArgumentException("관리자와 작성자만 수정할 수 있습니다.");
            }
        }
    }

}

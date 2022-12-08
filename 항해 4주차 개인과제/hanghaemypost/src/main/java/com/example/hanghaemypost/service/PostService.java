package com.example.hanghaemypost.service;


import com.example.hanghaemypost.Jwt.JwtUtil;
import com.example.hanghaemypost.dto.CommentDto;
import com.example.hanghaemypost.dto.PostDto;
import com.example.hanghaemypost.dto.PostRequestDto;
import com.example.hanghaemypost.entity.Comment;
import com.example.hanghaemypost.entity.Post;
import com.example.hanghaemypost.entity.User;
import com.example.hanghaemypost.entity.UserRoleEnum;
import com.example.hanghaemypost.repository.CommentReository;
import com.example.hanghaemypost.repository.PostRepository;
import com.example.hanghaemypost.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    private final CommentReository commentReository;

    @Transactional
    public PostDto createPost(PostRequestDto postRequestDto, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        if (token != null) {
            claims = checkClaims(token);

            User user = checkUser(claims);

            Post post = new Post(postRequestDto, user);
            postRepository.save(post);
            user.addPost(post);

            return new PostDto(post);

        } else throw new IllegalArgumentException("로그인을 해주세요!");
    }


    @Transactional(readOnly = true)
    public List<PostDto> getPosts() {

        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();

        ArrayList<PostDto> postDtoList = new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            List<Comment> comments = commentReository.findAllByPostOrderByCreatedAtDesc(posts.get(i));
            ArrayList<CommentDto> commentDtolist = new ArrayList<>();
            for (int j = 0; j < comments.size(); j++) {
                commentDtolist.add(new CommentDto(comments.get(j)));
            }

            postDtoList.add(new PostDto(posts.get(i), commentDtolist));
        }
        return postDtoList;
    }

    @Transactional(readOnly = true)
    public PostDto getOnePost(Long id) {

        Post post = checkPost(id);

        List<Comment> comments = commentReository.findAllByPostOrderByCreatedAtDesc(post);

        ArrayList<CommentDto> commentDtolist = new ArrayList<>();
        for (int j = 0; j < comments.size(); j++) {
            commentDtolist.add(new CommentDto(comments.get(j)));
        }

        return new PostDto(post, commentDtolist);
    }

    @Transactional
    public PostDto updatePost(Long id, PostRequestDto postRequestDto, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        if (token != null) {
            claims = checkClaims(token);

            User user = checkUser(claims);

            Post post = checkPost(id);

            CheckRole(user, post);

            post.update(postRequestDto);

            return new PostDto(post);

        } else throw new IllegalArgumentException("로그인을 해주세요!");
    }

    @Transactional
    public void deletePost(Long id, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        if (token != null) {
            claims = checkClaims(token);

            User user = checkUser(claims);

            Post post = checkPost(id);

            CheckRole(user, post);

            postRepository.deleteById(id);

        } else throw new IllegalArgumentException("로그인을 해주세요!");
    }


    //유저 확인
    private User checkUser(Claims claims) {
        User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                () -> new IllegalArgumentException("사용자가 존재하지 않습니다!")
        );
        return user;
    }

    //포스트 확인
    private Post checkPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다!")
        );
        return post;
    }

    //토큰 확인
    private Claims checkClaims(String token) {
        Claims claims;
        if (jwtUtil.validateToken(token)) {
            claims = jwtUtil.getUserInfoFromToken(token);
        } else throw new IllegalArgumentException("토큰이 유효하지 않습니다!");
        return claims;
    }

    //권한 확인
    private static void CheckRole(User user, Post post) {
        if (user.getRole() == UserRoleEnum.USER) {
            if (!post.getUser().getUsername().equals(user.getUsername())) {
                throw new IllegalArgumentException("관리자와 작성자만 수정할 수 있습니다!");
            }
        }
    }
}

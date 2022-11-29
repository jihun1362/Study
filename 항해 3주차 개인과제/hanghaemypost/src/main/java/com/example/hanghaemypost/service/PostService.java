package com.example.hanghaemypost.service;


import com.example.hanghaemypost.dto.PostRequestDto;
import com.example.hanghaemypost.dto.PostResponseDto;
import com.example.hanghaemypost.dto.ResponseDto;
import com.example.hanghaemypost.entity.Post;
import com.example.hanghaemypost.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return new PostResponseDto(post, "게시글 작성 완료!");
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> getPosts() {
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostResponseDto> postResponseDtolist=new ArrayList<>();
        for (int i = 0; i < posts.size(); i++) {
            postResponseDtolist.add(new PostResponseDto(posts.get(i), "전체게시글 조회 성공!"));
        }
        return postResponseDtolist;
    }

    @Transactional(readOnly = true)
    public PostResponseDto getOnePost(Long id) {
        Post post = checkPost(id);
        return new PostResponseDto(post, "게시글 조회 성공!");
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto postRequestDto) {
        Post post = checkPost(id);
        if (post.getPassword().equals(postRequestDto.getPassword())) {
            post.update(postRequestDto);
            return new PostResponseDto(post,"게시글 수정 완료!");
        } else
            return new PostResponseDto(post, "게시글 수정 실패!");
    }

    @Transactional
    public ResponseDto deletePost(Long id, String pw) {
        Post post = checkPost(id);
        if (post.getPassword().equals(pw)) {
            postRepository.deleteById(id);
            return new ResponseDto("게시글 삭제 완료!", HttpStatus.OK.value());
        } else
            return new ResponseDto("게시글 삭제 실패!", HttpStatus.OK.value());
    }

    //포스트 확인
    private Post checkPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지않습니다")
        );
        return post;
    }
}

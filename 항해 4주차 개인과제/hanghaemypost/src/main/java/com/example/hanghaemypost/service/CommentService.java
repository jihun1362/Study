package com.example.hanghaemypost.service;

import com.example.hanghaemypost.Jwt.JwtUtil;
import com.example.hanghaemypost.dto.CommentDto;
import com.example.hanghaemypost.dto.CommentRequestDto;
import com.example.hanghaemypost.entity.Comment;
import com.example.hanghaemypost.entity.Post;
import com.example.hanghaemypost.entity.User;
import com.example.hanghaemypost.repository.CommentReository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final JwtUtil jwtUtil;
    private final CommentReository commentReository;
    private final EffectivenessCheck effectivenessCheck;

    @Transactional
    public CommentDto createComment(Long id, CommentRequestDto commentRequestDto, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);

        if (token != null) {
            User user = effectivenessCheck.userAndTokenCheck(token);

            Post post = effectivenessCheck.postCheck(id);

            Comment comment = new Comment(commentRequestDto, post, user);
            commentReository.save(comment);
            post.addComment(comment);
            user.addComment(comment);

            return new CommentDto(comment);
        } else throw new IllegalArgumentException("로그인을 해주세요!");
    }

    @Transactional
    public CommentDto updateComment(Long id, CommentRequestDto commentRequestDto, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);

        if (token != null) {
            User user = effectivenessCheck.userAndTokenCheck(token);

            Comment comment = effectivenessCheck.commentCheck(id);

            effectivenessCheck.commentRoleCheck(user, comment);

            comment.update(commentRequestDto);

            return new CommentDto(comment);
        } else throw new IllegalArgumentException("로그인을 해주세요!");
    }

    @Transactional
    public void deleteComment(Long id, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);

        if (token != null) {
            User user = effectivenessCheck.userAndTokenCheck(token);

            Comment comment = effectivenessCheck.commentCheck(id);

            effectivenessCheck.commentRoleCheck(user, comment);

            commentReository.deleteById(id);
        } else throw new IllegalArgumentException("로그인을 해주세요!");
    }
}

//package com.example.hanghaemypost.service;
//
//        import com.example.hanghaemypost.Jwt.JwtUtil;
//        import com.example.hanghaemypost.dto.CommentDto;
//        import com.example.hanghaemypost.dto.CommentRequestDto;
//        import com.example.hanghaemypost.entity.Comment;
//        import com.example.hanghaemypost.entity.Post;
//        import com.example.hanghaemypost.entity.User;
//        import com.example.hanghaemypost.entity.UserRoleEnum;
//        import com.example.hanghaemypost.repository.CommentReository;
//        import com.example.hanghaemypost.repository.PostRepository;
//        import com.example.hanghaemypost.repository.UserRepository;
//        import io.jsonwebtoken.Claims;
//        import jakarta.servlet.http.HttpServletRequest;
//        import lombok.RequiredArgsConstructor;
//        import org.springframework.stereotype.Service;
//        import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class CommentService {
//    private final JwtUtil jwtUtil;
//    private final CommentReository commentReository;
//    private final UserRepository userRepository;
//    private final PostRepository postRepository;
//
//    @Transactional
//    public CommentDto createComment(Long id, CommentRequestDto commentRequestDto, HttpServletRequest request) {
//        String token = jwtUtil.resolveToken(request);
//        Claims claims;
//
//        if (token != null) {
//            if (jwtUtil.validateToken(token)) {
//                claims = jwtUtil.getUserInfoFromToken(token);
//            } else throw new IllegalArgumentException("토큰이 유효하지 않습니다.");
//
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다!")
//            );
//
//            Post post = postRepository.findById(id).orElseThrow(
//                    () -> new IllegalArgumentException("게시글이 존재하지 않습니다!")
//            );
//
//            Comment comment = new Comment(commentRequestDto, post, user);
//            commentReository.save(comment);
//            post.addComment(comment);
//            user.addComment(comment);
//
//            return new CommentDto(comment);
//        } else throw new IllegalArgumentException("로그인을 해주세요!");
//    }
//
//    @Transactional
//    public CommentDto updateComment(Long id, CommentRequestDto commentRequestDto, HttpServletRequest request) {
//        String token = jwtUtil.resolveToken(request);
//        Claims claims;
//
//        if (token != null) {
//            if (jwtUtil.validateToken(token)) {
//                claims = jwtUtil.getUserInfoFromToken(token);
//            } else throw new IllegalArgumentException("토큰이 유효하지 않습니다.");
//
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다!")
//            );
//
//            Comment comment = commentReository.findById(id).orElseThrow(
//                    () -> new IllegalArgumentException("댓글이 존재하지 않습니다!")
//            );
//
//            if (user.getRole() == UserRoleEnum.USER) {
//                if (!comment.getUser().getUsername().equals(user.getUsername())) {
//                    throw new IllegalArgumentException("관리자와 작성자만 수정할 수 있습니다.");
//                }
//            }
//
//            comment.update(commentRequestDto);
//            return new CommentDto(comment);
//
//        } else throw new IllegalArgumentException("로그인을 해주세요!");
//    }
//
//    @Transactional
//    public void deleteComment(Long id, HttpServletRequest request) {
//        String token = jwtUtil.resolveToken(request);
//        Claims claims;
//
//        if (token != null) {
//            if (jwtUtil.validateToken(token)) {
//                claims = jwtUtil.getUserInfoFromToken(token);
//            } else throw new IllegalArgumentException("토큰이 유효하지 않습니다.");
//
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다!")
//            );
//
//            Comment comment = commentReository.findById(id).orElseThrow(
//                    () -> new IllegalArgumentException("댓글이 존재하지 않습니다!")
//            );
//
//            if (user.getRole() == UserRoleEnum.USER) {
//                if (!comment.getUser().getUsername().equals(user.getUsername())) {
//                    throw new IllegalArgumentException("관리자와 작성자만 수정할 수 있습니다.");
//                }
//            }
//            commentReository.deleteById(id);
//        } else throw new IllegalArgumentException("로그인을 해주세요!");
//    }
//}
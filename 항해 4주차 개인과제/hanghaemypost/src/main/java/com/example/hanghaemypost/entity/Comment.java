package com.example.hanghaemypost.entity;

import com.example.hanghaemypost.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    public Comment(CommentRequestDto commentRequestDto, Post post, User user) {
        this.content = commentRequestDto.getContent();
        this.post = post;
        this.user = user;
    }

    public void update(CommentRequestDto commentRequestDto) {
        this.content=commentRequestDto.getContent();
    }
}

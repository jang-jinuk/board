package com.post.board.post;

import com.post.board.member.Member;
import com.post.board.post.dto.PostCreateRequest;
import com.post.board.post.dto.PostUpdateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Post(PostCreateRequest postCreateRequest) {
        this.title = postCreateRequest.getTitle();
        this.content = postCreateRequest.getContent();
        this.createAt = LocalDateTime.now();
    }

    public void update(PostUpdateRequest postUpdateRequest) {
        this.title = postUpdateRequest.getTitle();
        this.content = postUpdateRequest.getContent();
        this.updateAt = LocalDateTime.now();
    }
}

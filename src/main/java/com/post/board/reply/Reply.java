package com.post.board.reply;

import com.post.board.member.Member;
import com.post.board.post.Post;
import com.post.board.reply.dto.ReplyCreateRequest;
import com.post.board.reply.dto.ReplyUpdateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Reply(ReplyCreateRequest replyCreateRequest, Post post) {
        this.content = replyCreateRequest.getContent();
        this.createAt = LocalDateTime.now();
        this.post = post;
    }

    public void update(ReplyUpdateRequest replyUpdateRequest) {
        this.content = replyUpdateRequest.getContent();
        this.updateAt = LocalDateTime.now();
    }
}

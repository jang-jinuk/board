package com.post.board.post.dto;

import com.post.board.reply.Reply;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class PostDetailResponse {
    private String title;
    private String content;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private List<Reply> replies;
}

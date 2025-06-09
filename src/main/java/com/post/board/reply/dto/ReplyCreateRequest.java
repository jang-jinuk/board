package com.post.board.reply.dto;

import lombok.Getter;

@Getter
public class ReplyCreateRequest {
    private Long postId;
    private String content;
}

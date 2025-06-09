package com.post.board.member.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String memberName;
    private String password;
}

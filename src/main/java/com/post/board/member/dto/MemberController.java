package com.post.board.member.dto;

import com.post.board.member.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        boolean result = memberService.authenticateUser(loginRequest);
        if (result) {
            session.setAttribute("loginUser", loginRequest.getMemberName());
        }
    }
}

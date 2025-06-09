package com.post.board.member;

import com.post.board.member.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public boolean authenticateUser(LoginRequest loginRequest) {
        Member member = memberRepository.findMemberByMemberName(loginRequest.getMemberName());
        String password = member.getPassword();
        if (password.equals(loginRequest.getPassword())) {
            return true;
        }
        return false;
    }
}

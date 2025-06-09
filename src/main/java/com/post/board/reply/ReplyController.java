package com.post.board.reply;

import com.post.board.reply.dto.ReplyCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/post/{postId}/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping
    public Map<String, Long> createReply(@RequestBody ReplyCreateRequest replyCreateRequest) {
        Reply reply = replyService.createReply(replyCreateRequest);
        return Map.of("postId", reply.getPost().getId());
    }

}

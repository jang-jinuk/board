package com.post.board.reply;

import com.post.board.reply.dto.ReplyCreateRequest;
import com.post.board.reply.dto.ReplyUpdateRequest;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/post/{postId}/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping
    public Map<String, Long> createReply(@RequestBody ReplyCreateRequest replyCreateRequest) {
        replyService.createReply(replyCreateRequest);
        return Map.of("postId", replyCreateRequest.getPostId());
    }

    @PatchMapping("/{replyId}")
    public Map<String, Long> updateReply(@PathParam("replyId") Long replyId,
                                         @PathParam("postId") Long postId,
                                         @RequestBody ReplyUpdateRequest replyUpdateRequest) {
        replyService.updateReply(replyId, replyUpdateRequest);
        return Map.of("postId", postId);
    }
}

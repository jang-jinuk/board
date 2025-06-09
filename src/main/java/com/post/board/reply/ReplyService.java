package com.post.board.reply;

import com.post.board.post.Post;
import com.post.board.post.PostRepository;
import com.post.board.reply.dto.ReplyCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;

    public Reply createReply(ReplyCreateRequest replyCreateRequest) {
        Post foudPost = postRepository.findById(replyCreateRequest.getPostId()).get();
        return replyRepository.save(new Reply(replyCreateRequest, foudPost));
    }
}

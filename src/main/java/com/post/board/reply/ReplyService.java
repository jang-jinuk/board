package com.post.board.reply;

import com.post.board.post.Post;
import com.post.board.post.PostRepository;
import com.post.board.reply.dto.ReplyCreateRequest;
import com.post.board.reply.dto.ReplyUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;

    public List<Reply> findReplyListByPost(Post post) {
        return replyRepository.findReplyByPost(post);
    }

    public void createReply(ReplyCreateRequest replyCreateRequest) {
        Post foudPost = postRepository.findById(replyCreateRequest.getPostId()).get();
        replyRepository.save(new Reply(replyCreateRequest, foudPost));
    }

    public void updateReply(Long replyId, ReplyUpdateRequest replyUpdateRequest) {
        Reply foundReply = replyRepository.findById(replyId).get();
        foundReply.update(replyUpdateRequest);
        replyRepository.save(foundReply);
    }

    public void deleteReply(Long replyId) {
        replyRepository.deleteById(replyId);
    }
}

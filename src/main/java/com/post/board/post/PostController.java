package com.post.board.post;

import com.post.board.post.dto.PostCreateRequest;
import com.post.board.post.dto.PostDetailResponse;
import com.post.board.post.dto.PostUpdateRequest;
import com.post.board.reply.Reply;
import com.post.board.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final ReplyService replyService;

    @GetMapping("/{id}")
    public PostDetailResponse getPost(@PathVariable Long id) {
        Post post = postService.findPost(id);
        List<Reply> replies = replyService.findReplyListByPost(post);
        return PostDetailResponse.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .createAt(post.getCreateAt())
                .updateAt(post.getUpdateAt())
                .replies(replies)
                .build();
    }

    @GetMapping
    public List<Post> getPostList() {
        return postService.findAllPost();
    }

    @PostMapping
    public Map<String, Long> createPost(@RequestBody PostCreateRequest postCreateRequest) {
        return Map.of("postId", postService.createPost(postCreateRequest));
    }

    @PatchMapping("/{id}")
    public Map<String, Long> updatePost(@PathVariable Long id,
                                        @RequestBody PostUpdateRequest postUpdateRequest) {
        return Map.of("postId", postService.updatePost(id, postUpdateRequest));
    }
}

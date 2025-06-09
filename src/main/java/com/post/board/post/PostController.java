package com.post.board.post;

import com.post.board.post.dto.PostCreateRequest;
import com.post.board.post.dto.PostDetailResponse;
import com.post.board.post.dto.PostUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public PostDetailResponse getPost(@PathVariable("id") Long id) {
        return postService.findPost(id);
    }

    @PostMapping
    public Map<String, Long> createPost(@RequestBody PostCreateRequest postCreateRequest) {
        return Map.of("postId", postService.createPost(postCreateRequest));
    }

    @PatchMapping("/{id}")
    public Map<String, Long> updatePost(@PathVariable("id") Long id,
                                        @RequestBody PostUpdateRequest postUpdateRequest) {
        return Map.of("postId", postService.updatePost(id, postUpdateRequest));
    }
}

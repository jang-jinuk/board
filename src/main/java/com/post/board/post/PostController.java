package com.post.board.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Map<String, Long> createPost(@RequestBody PostCreateRequest postCreateRequest) {
        return Map.of("postId", postService.createPost(postCreateRequest));
    }
}

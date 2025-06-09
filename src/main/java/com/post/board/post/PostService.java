package com.post.board.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Long createPost(PostCreateRequest postCreateRequest) {
        Post post = postRepository.save(new Post(postCreateRequest));
        return post.getId();
    }
}

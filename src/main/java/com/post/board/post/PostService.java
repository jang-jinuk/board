package com.post.board.post;

import com.post.board.post.dto.PostCreateRequest;
import com.post.board.post.dto.PostUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> findAllPost() {
        return postRepository.findAll();
    }

    public Post findPost(Long id) {
        return postRepository.findById(id).get();
    }

    public Long createPost(PostCreateRequest postCreateRequest) {
        Post post = postRepository.save(new Post(postCreateRequest));
        return post.getId();
    }

    @Transactional
    public Long updatePost(Long id, PostUpdateRequest postUpdateRequest) {
        Post post = postRepository.findById(id).get();
        post.update(postUpdateRequest);
        Post updatedPost = postRepository.save(post);
        return updatedPost.getId();
    }
}

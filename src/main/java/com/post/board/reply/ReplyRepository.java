package com.post.board.reply;

import com.post.board.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findReplyByPost(Post post);
}

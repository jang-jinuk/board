package com.post.board.reply;

import com.post.board.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findReplyByPost(Post post);

    @Modifying
    @Query("DELETE FROM Reply r WHERE r.post.id = :postId")
    void deleteAllByPostId(Long postId);
}

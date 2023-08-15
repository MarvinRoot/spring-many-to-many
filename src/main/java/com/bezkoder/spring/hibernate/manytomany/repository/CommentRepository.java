package com.bezkoder.spring.hibernate.manytomany.repository;

import com.bezkoder.spring.hibernate.manytomany.model.Comment;
import com.bezkoder.spring.hibernate.manytomany.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentsBySongId(long songId);
    List<Comment> findCommentsByUserId(long userId);
}

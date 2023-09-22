package com.bezkoder.spring.hibernate.manytomany.service;

import com.bezkoder.spring.hibernate.manytomany.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    List<Comment> getCommentsOfSong(long id);
    List<Comment> getCommentsOfUser(long id);
    Comment createComment(Comment comment);
}

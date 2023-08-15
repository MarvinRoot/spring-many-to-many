package com.bezkoder.spring.hibernate.manytomany.service;

import com.bezkoder.spring.hibernate.manytomany.model.Artist;
import com.bezkoder.spring.hibernate.manytomany.model.Comment;
import com.bezkoder.spring.hibernate.manytomany.repository.ArtistRepository;
import com.bezkoder.spring.hibernate.manytomany.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getCommentsOfSong(long id) {
        return commentRepository.findCommentsBySongId(id);
    }

    @Override
    public List<Comment> getCommentsOfUser(long id) {
        return commentRepository.findCommentsByUserId(id);
    }
}

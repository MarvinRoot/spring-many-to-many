package com.bezkoder.spring.hibernate.manytomany.controller;

import com.bezkoder.spring.hibernate.manytomany.exception.ResourceNotFoundException;
import com.bezkoder.spring.hibernate.manytomany.model.Comment;
import com.bezkoder.spring.hibernate.manytomany.model.Playlist;
import com.bezkoder.spring.hibernate.manytomany.model.Song;
import com.bezkoder.spring.hibernate.manytomany.model.User;
import com.bezkoder.spring.hibernate.manytomany.service.CommentService;
import com.bezkoder.spring.hibernate.manytomany.service.PlaylistService;
import com.bezkoder.spring.hibernate.manytomany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PlaylistService playlistService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllTags() {

        List<User> users = new ArrayList<User>(userService.getAllUsers());

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {

        User artist = userService.getUserById(id);

        if (artist == null) {
            throw new ResourceNotFoundException("Not found User with id = " + id);
        }

        return new ResponseEntity<>(artist, HttpStatus.OK);
    }


    @GetMapping("/users/{id}/playlists")
    public ResponseEntity<List<Playlist>> getAllUserPlaylists(@PathVariable("id") long id) {

        List<Playlist> playlists = new ArrayList<Playlist>(playlistService.findPlaylistsByUserId(id));

        if (playlists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/users/{id}/comments")
    public ResponseEntity<List<Comment>> getAllUserComments(@PathVariable("id") long id) {

        List<Comment> playlists = new ArrayList<Comment>(commentService.getCommentsOfUser(id));

        if (playlists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }
}

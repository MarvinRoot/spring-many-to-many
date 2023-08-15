package com.bezkoder.spring.hibernate.manytomany.controller;

import com.bezkoder.spring.hibernate.manytomany.exception.ResourceNotFoundException;
import com.bezkoder.spring.hibernate.manytomany.model.Comment;
import com.bezkoder.spring.hibernate.manytomany.model.Song;
import com.bezkoder.spring.hibernate.manytomany.repository.SongRepository;
import com.bezkoder.spring.hibernate.manytomany.service.CommentService;
import com.bezkoder.spring.hibernate.manytomany.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SongController {
    @Autowired
    private SongService songService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllTags() {
        List<Song> songs = new ArrayList<Song>();

        songService.getAllSongs().forEach(songs::add);

        if (songs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable(value = "id") Long id) {

        Song artist = songService.getSongById(id);

        if (artist == null) {
            throw new ResourceNotFoundException("Not found Song with id = " + id);
        }

        return new ResponseEntity<>(artist, HttpStatus.OK);
    }


    @GetMapping("/songs/{id}/comments")
    public ResponseEntity<List<Comment>> getAllUserComments(@PathVariable("id") long id) {

        List<Comment> playlists = new ArrayList<Comment>(commentService.getCommentsOfSong(id));

        if (playlists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }
}

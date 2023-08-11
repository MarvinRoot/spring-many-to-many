package com.bezkoder.spring.hibernate.manytomany.controller;

import com.bezkoder.spring.hibernate.manytomany.model.Song;
import com.bezkoder.spring.hibernate.manytomany.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SongController {
    @Autowired
    private SongRepository songRepository;

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllTags() {
        List<Song> songs = new ArrayList<Song>();

        songRepository.findAll().forEach(songs::add);

        if (songs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
}

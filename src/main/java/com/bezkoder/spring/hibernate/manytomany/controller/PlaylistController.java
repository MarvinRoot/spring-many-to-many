package com.bezkoder.spring.hibernate.manytomany.controller;

import com.bezkoder.spring.hibernate.manytomany.model.Playlist;
import com.bezkoder.spring.hibernate.manytomany.repository.PlaylistRepository;
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
public class PlaylistController {
    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping("/playlists")
    public ResponseEntity<List<Playlist>> getAllTags() {
        List<Playlist> playlists = new ArrayList<Playlist>();

        playlistRepository.findAll().forEach(playlists::add);

        if (playlists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }
}

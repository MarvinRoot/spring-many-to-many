package com.bezkoder.spring.hibernate.manytomany.controller;

import com.bezkoder.spring.hibernate.manytomany.exception.ResourceNotFoundException;
import com.bezkoder.spring.hibernate.manytomany.model.Artist;
import com.bezkoder.spring.hibernate.manytomany.model.Playlist;
import com.bezkoder.spring.hibernate.manytomany.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/playlists")
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        List<Playlist> playlists = new ArrayList<Playlist>();

        playlistService.findAll().forEach(playlists::add);

        if (playlists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/playlists/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable(value = "id") Long id) {

        Playlist playlist = playlistService.findPlaylistById(id);

        if (playlist == null) {
            throw new ResourceNotFoundException("Not found Playlist with id = " + id);
        }

        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

}

package com.bezkoder.spring.hibernate.manytomany.controller;

import com.bezkoder.spring.hibernate.manytomany.model.Artist;
import com.bezkoder.spring.hibernate.manytomany.model.Song;
import com.bezkoder.spring.hibernate.manytomany.repository.SongRepository;
import com.bezkoder.spring.hibernate.manytomany.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ArtistController {
//    @Autowired
//    private ArtistRepository artistRepository;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getAllTags() {

        List<Artist> artists = new ArrayList<Artist>(artistService.getAllArtists());

        if (artists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/artists/{id}/songs")
    public ResponseEntity<List<Song>> getAllArtistSongs(@PathVariable("id") long id) {

        List<Song> songs = new ArrayList<Song>(songRepository.findSongsByArtistsId(id));

        if (songs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
}

package com.bezkoder.spring.hibernate.manytomany.controller;

import com.bezkoder.spring.hibernate.manytomany.model.Artist;
import com.bezkoder.spring.hibernate.manytomany.model.Genre;
import com.bezkoder.spring.hibernate.manytomany.model.Playlist;
import com.bezkoder.spring.hibernate.manytomany.model.Song;
import com.bezkoder.spring.hibernate.manytomany.service.ArtistService;
import com.bezkoder.spring.hibernate.manytomany.service.GenreService;
import com.bezkoder.spring.hibernate.manytomany.service.PlaylistService;
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
public class GenreController {
    @Autowired
    private GenreService genreService;
    @Autowired
    private SongService songService;
    @Autowired
    private ArtistService artistService;

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        List<Genre> genres = new ArrayList<Genre>();

        genreService.getAllGenres().forEach(genres::add);

        if (genres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @GetMapping("/genres/{id}/songs")
    public ResponseEntity<List<Song>> getAllGenreSongs(@PathVariable("id") long id) {

        List<Song> songs = new ArrayList<Song>(songService.findSongsByGenreId(id));

        if (songs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/genres/{id}/artists")
    public ResponseEntity<List<Artist>> getAllGenreArtists(@PathVariable("id") long id) {

        List<Artist> songs = new ArrayList<Artist>(artistService.getArtistsByGenreId(id));

        if (songs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
}

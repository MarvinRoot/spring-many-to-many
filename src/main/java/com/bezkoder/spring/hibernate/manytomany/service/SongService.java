package com.bezkoder.spring.hibernate.manytomany.service;

import com.bezkoder.spring.hibernate.manytomany.model.Artist;
import com.bezkoder.spring.hibernate.manytomany.model.Song;

import java.util.List;

public interface SongService {
    List<Song> getAllSongs();
    Song getSongById(long id);
    List<Song> findSongsByArtistsId(long id);
    List<Song> findSongsByGenreId(long id);
}

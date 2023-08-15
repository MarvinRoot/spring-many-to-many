package com.bezkoder.spring.hibernate.manytomany.service;

import com.bezkoder.spring.hibernate.manytomany.model.Artist;
import com.bezkoder.spring.hibernate.manytomany.model.Song;
import com.bezkoder.spring.hibernate.manytomany.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    SongRepository songRepository;

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(long id) {
        return songRepository.findSongById(id);
    }

    @Override
    public List<Song> findSongsByArtistsId(long id) {
        return songRepository.findSongsByArtistsId(id);
    }

    @Override
    public List<Song> findSongsByGenreId(long id) {
        return songRepository.findSongsByGenreId(id);
    }
}

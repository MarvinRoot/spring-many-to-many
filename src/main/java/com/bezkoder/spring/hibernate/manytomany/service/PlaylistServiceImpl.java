package com.bezkoder.spring.hibernate.manytomany.service;

import com.bezkoder.spring.hibernate.manytomany.model.Playlist;
import com.bezkoder.spring.hibernate.manytomany.model.Song;
import com.bezkoder.spring.hibernate.manytomany.repository.PlaylistRepository;
import com.bezkoder.spring.hibernate.manytomany.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService{

    @Autowired
    PlaylistRepository playlistRepository;

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public List<Playlist> findPlaylistsByUserId(long id) {
        return playlistRepository.findPlaylistsByUserId(id);
    }

    @Override
    public Playlist findPlaylistById(long id) {
        return playlistRepository.findPlaylistById(id);
    }
}

package com.bezkoder.spring.hibernate.manytomany.service;

import com.bezkoder.spring.hibernate.manytomany.model.Playlist;
import com.bezkoder.spring.hibernate.manytomany.model.Song;

import java.util.List;

public interface PlaylistService {
    List<Playlist> findAll();
    List<Playlist> findPlaylistsByUserId(long id);
    Playlist findPlaylistById(long id);
}

package com.bezkoder.spring.hibernate.manytomany.service;

import com.bezkoder.spring.hibernate.manytomany.model.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> getAllArtists();
    List<Artist> getArtistsByGenreId(long id);
    Artist getArtistById(long id);
}

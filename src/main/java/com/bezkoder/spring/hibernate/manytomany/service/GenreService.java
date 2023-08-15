package com.bezkoder.spring.hibernate.manytomany.service;

import com.bezkoder.spring.hibernate.manytomany.model.Artist;
import com.bezkoder.spring.hibernate.manytomany.model.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();
}

package com.bezkoder.spring.hibernate.manytomany.service;

import com.bezkoder.spring.hibernate.manytomany.model.Artist;
import com.bezkoder.spring.hibernate.manytomany.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArtistServiceImpl implements ArtistService{

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }
}

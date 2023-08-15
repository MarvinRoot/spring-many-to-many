package com.bezkoder.spring.hibernate.manytomany.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "favoriteArtists")
    @JsonIgnore
    private Set<User> users = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "artist_songs", joinColumns = { @JoinColumn(name = "artist_id") }, inverseJoinColumns = {
            @JoinColumn(name = "song_id") })
    @JsonIgnore
    private Set<Song> songs = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false, name = "genre_id")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JsonIgnore
    private Genre genre;

//    @Transient
//    private long genreId;

    public Artist() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

//    public long getGenreId() {
//        return genre.getId();
//    }
//
//    public void setGenreId(long genreId) {
//        this.genreId = genreId;
//    }

    @Override
    public String toString() {
        return "Tutorial [id=" + getId() + ", name=" + getName() + "]";
    }
}


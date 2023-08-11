package com.bezkoder.spring.hibernate.manytomany.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, name = "username")
    private String username;

    @Column(unique = true, name = "email")
    private String email;

    @Column
    private String password;

    @Column
    private String profileImg;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "favorite_artists", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "artist_id") })
    private Set<Artist> favoriteArtists = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "favorite_songs", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "song_id") })
    private Set<Song> favoriteSongs = new HashSet<>();

    public User() {
    }

    public User(long id, String username, String email, String password, String profileImg) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileImg = profileImg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public Set<Artist> getFavoriteArtists() {
        return favoriteArtists;
    }

    public void setFavoriteArtists(Set<Artist> favoriteArtists) {
        this.favoriteArtists = favoriteArtists;
    }

    public Set<Song> getFavoriteSongs() {
        return favoriteSongs;
    }

    public void setFavoriteSongs(Set<Song> favoriteSongs) {
        this.favoriteSongs = favoriteSongs;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", username=" + username + ", email=" + email +"]";
    }

}


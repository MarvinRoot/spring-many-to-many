package com.bezkoder.spring.hibernate.manytomany.repository;

import com.bezkoder.spring.hibernate.manytomany.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
//  @Query(value = "select * from tutorials where title like %:title% ", nativeQuery = true)
  List<Song> findByTitleContaining(String name);
  List<Song> findSongsByArtistsId(Long artistId);
  Song findSongById(Long id);
  @Query(value = "select * from song where genre_id = :genreId ", nativeQuery = true)
  List<Song> findSongsByGenreId(Long genreId);
}

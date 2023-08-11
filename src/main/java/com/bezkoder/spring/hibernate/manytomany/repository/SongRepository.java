package com.bezkoder.spring.hibernate.manytomany.repository;

import com.bezkoder.spring.hibernate.manytomany.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
//  @Query(value = "select * from tutorials where title like %:title% ", nativeQuery = true)
  List<Song> findByTitleContaining(String name);

  List<Song> findSongsByArtistsId(Long artistId);
}

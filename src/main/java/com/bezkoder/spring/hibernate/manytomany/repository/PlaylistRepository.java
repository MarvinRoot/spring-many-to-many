package com.bezkoder.spring.hibernate.manytomany.repository;

import com.bezkoder.spring.hibernate.manytomany.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
//  @Query(value = "select * from tutorials where title like %:title% ", nativeQuery = true)
  List<Playlist> findByTitleContaining(String title);
}

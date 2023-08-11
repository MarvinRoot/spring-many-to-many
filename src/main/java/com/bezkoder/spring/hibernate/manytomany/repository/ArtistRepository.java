package com.bezkoder.spring.hibernate.manytomany.repository;

import com.bezkoder.spring.hibernate.manytomany.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
//  @Query(value = "select * from tutorials where title like %:title% ", nativeQuery = true)
  List<Artist> findByNameContaining(String name);
}

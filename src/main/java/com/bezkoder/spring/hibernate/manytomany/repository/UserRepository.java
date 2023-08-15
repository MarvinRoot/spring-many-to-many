package com.bezkoder.spring.hibernate.manytomany.repository;

import com.bezkoder.spring.hibernate.manytomany.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//  @Query(value = "select * from tutorials where title like %:title% ", nativeQuery = true)
  List<User> findByUsernameContaining(String username);
  User findUserById(long id);
}

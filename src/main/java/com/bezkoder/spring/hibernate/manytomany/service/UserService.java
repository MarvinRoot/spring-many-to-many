package com.bezkoder.spring.hibernate.manytomany.service;

import com.bezkoder.spring.hibernate.manytomany.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
}

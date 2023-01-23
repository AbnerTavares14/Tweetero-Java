package com.tweetero.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetero.main.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
}

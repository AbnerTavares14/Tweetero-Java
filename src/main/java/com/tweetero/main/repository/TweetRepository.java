package com.tweetero.main.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetero.main.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findByUsername(String username);
}

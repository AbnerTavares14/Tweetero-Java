package com.tweetero.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tweetero.main.dto.TweetDTO;
import com.tweetero.main.model.Tweet;
import com.tweetero.main.model.UserModel;
import com.tweetero.main.repository.TweetRepository;
import com.tweetero.main.repository.UserRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<Tweet> listTweetsOfUser(String username) {
        return repository.findByUsername(username);
    }

    public Page<Tweet> findAll(int page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("id").descending());
        return repository.findAll(pageable);
    }

    public ResponseEntity<String> save(TweetDTO dto) {
        UserModel user = userRepository.findByUsername(dto.username());
        if (user != null) {
            repository.save(new Tweet(dto, user.getAvatar()));
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User doesn't exist!");
        }
    }
}

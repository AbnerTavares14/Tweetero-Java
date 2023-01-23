package com.tweetero.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.main.dto.TweetDTO;
import com.tweetero.main.model.Tweet;
import com.tweetero.main.service.TweetService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweet")
public class TweetController {
    @Autowired
    private TweetService service;

    @GetMapping
    public Page<Tweet> list(@RequestParam(value = "page", defaultValue = "0") int page) {
        return service.findAll(page);
    }

    @GetMapping(path = { "/{username}" })
    public List<Tweet> listTweetsByUsername(@PathVariable String username) {
        List<Tweet> tweets = service.listTweetsOfUser(username);
        System.out.println(tweets);
        return tweets;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody TweetDTO req) {
        return service.save(req);
    }
}

package com.tweetero.main.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.main.dto.TweetDTO;
import com.tweetero.main.model.Tweet;
import com.tweetero.main.service.TweetService;

@RestController
@RequestMapping("/tweet")
public class TweetController {
    @Autowired
    private TweetService service;

    @GetMapping
    public Page<Tweet> list(@PageableDefault(page = 0, size = 5) Pageable page) {
        return service.findAll(page);
    }

    @GetMapping(path = { "/{username}" })
    public List<Tweet> listTweetsByUsername(@PathVariable String username) {
        return service.listTweetsOfUser(username);
    }

    @PostMapping
    public String create(@RequestBody TweetDTO req) {
        service.save(req);
        return "OK";
    }
}

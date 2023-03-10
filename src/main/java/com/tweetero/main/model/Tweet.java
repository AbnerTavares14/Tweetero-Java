package com.tweetero.main.model;

import com.tweetero.main.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String tweet;

    @Column
    private String avatar;

    public Tweet(TweetDTO data, String avatar) {
        this.username = data.username();
        this.avatar = avatar;
        this.tweet = data.tweet();
    }
}

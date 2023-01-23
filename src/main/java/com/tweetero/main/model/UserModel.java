package com.tweetero.main.model;

import com.tweetero.main.dto.UserDTO;

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
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String avatar;

    public UserModel(UserDTO data) {
        this.avatar = data.avatar();
        this.username = data.username();
    }
}

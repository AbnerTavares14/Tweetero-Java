package com.tweetero.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetero.main.dto.UserDTO;
import com.tweetero.main.model.UserModel;
import com.tweetero.main.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserModel save(UserDTO dto) {
        return repository.save(new UserModel(dto));
    }
}

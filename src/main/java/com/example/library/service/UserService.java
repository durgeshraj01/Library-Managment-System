package com.example.library.service;

import com.example.library.entity.Profile;
import com.example.library.entity.User;
import com.example.library.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user) {
        if (user.getProfile() != null) {
            user.getProfile().setUser(user);
        } else {
            Profile profile = new Profile();
            profile.setUser(user);
            user.setProfile(profile);
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}

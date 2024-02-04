package com.syshco.grpc.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(String username) {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);
        return optionalUser.orElse(null);
    }

    public UserEntity createUser(UserEntity user) {
        // You can set any default values or perform additional validation before saving
        return userRepository.save(user);
    }

    public UserEntity updateUser(String username, UserEntity updatedUser) {
        if (userRepository.existsByUsername(username)) {
            updatedUser.setUsername(username);
            return userRepository.save(updatedUser);
        }
        return null; // User not found
    }

    public boolean deleteUser(String username) {
        if (userRepository.existsByUsername(username)) {
            userRepository.deleteByUsername(username);
            return true;
        }
        return false; // User not found
    }
}

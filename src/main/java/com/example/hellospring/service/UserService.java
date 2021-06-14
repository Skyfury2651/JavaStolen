package com.example.hellospring.service;

import com.example.hellospring.entity.User;
import com.example.hellospring.model.dto.UserDTO;
import com.example.hellospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public UserDTO store(UserDTO userDTO) {
        User user = userDTO.toUser();
        user.setPasswordHash(bCryptPasswordEncoder.encode(user.getPasswordHash()));
        userRepository.save(user);

        return new UserDTO(user);
    }
}

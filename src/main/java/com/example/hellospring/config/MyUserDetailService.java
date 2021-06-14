package com.example.hellospring.config;

import com.example.hellospring.entity.User;
import com.example.hellospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    // check login
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(s);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();

            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPasswordHash())
                    .roles("ADMIN")
                    .build();

            return userDetails;
        }


        return null;
    }
}

package com.example.hellospring.model.dto;

import com.example.hellospring.entity.User;
import com.example.hellospring.entity.UserInformation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private String username;
    private String email;
    private String passwordHash;
    private String phoneNumber;
    private int UserId;

    public User toUser() {

        UserInformation userInformation = new UserInformation();
        userInformation.setUserId(this.UserId);
        userInformation.setEmail(this.email);
        userInformation.setPhoneNumber(this.phoneNumber);

        User user = new User();
        user.setEmail(this.email);
        user.setUsername(this.username);
        user.setPasswordHash(this.passwordHash);
        user.setUserInformation(userInformation);

        return user;
    }

    public UserDTO() {

    }

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.passwordHash = user.getPasswordHash();
        this.phoneNumber = user.getUserInformation().getPhoneNumber();
        this.UserId = user.getId();
    }
}

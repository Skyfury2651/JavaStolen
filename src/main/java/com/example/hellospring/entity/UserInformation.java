package com.example.hellospring.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserInformation {

    @Id
    private int id;

    @Nullable
    private String phoneNumber;
    @Nullable
    private String email;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column(insertable = false, updatable = false)
    private int userId;
}

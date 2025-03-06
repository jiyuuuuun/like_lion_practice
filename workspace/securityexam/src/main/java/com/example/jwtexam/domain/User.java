package com.example.jwtexam.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "lion_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false,length = 100)
    private String password;

    @Column(nullable = false,length = 50)
    private String name;

    @Column(nullable = false,length = 100)
    private String email;

    @Column(name = "registration_date",nullable = false, updatable = false)
    private LocalDateTime registrationDate=LocalDateTime.now();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

}



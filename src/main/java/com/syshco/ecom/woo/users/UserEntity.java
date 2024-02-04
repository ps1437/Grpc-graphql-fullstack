package com.syshco.ecom.woo.users;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "USERS")
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;

}

package com.suirtech.automation.testservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "test_users", schema = "users")
public class User  {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username", unique=true)
    private String userName;
    @Column(name = "password")
    private String password;

    public User(String userName, String password, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

}

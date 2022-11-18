package com.local.springproject.User;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "UserData")
public class UserClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String imageURL;

    public UserClass(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserClass() {

    }
}

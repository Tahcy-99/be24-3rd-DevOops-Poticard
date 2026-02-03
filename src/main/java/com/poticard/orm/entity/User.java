package com.poticard.orm.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column(length = 20)
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// CREATE TABLE user (
//      idx INT PRIMARY KEY AUTO_INCREMENT,
//      name VARCHAR(20)
// )

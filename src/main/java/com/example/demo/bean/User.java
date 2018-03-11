package com.example.demo.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zenglw on 2018/3/11.
 */

public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    private @Getter @Setter String username;
    private @Getter @Setter Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
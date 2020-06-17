package com.lt.spring.security.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
}

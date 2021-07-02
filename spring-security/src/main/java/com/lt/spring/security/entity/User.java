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

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = Class.forName("org.springframework.security.web.access.expression.WebExpressionConfigAttribute");
        Object object = aClass.newInstance();
        System.out.println(aClass);
    }
}

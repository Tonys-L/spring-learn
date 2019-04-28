package com.lt.spring.security.dao;

import com.lt.spring.security.entity.User;
import org.springframework.data.repository.Repository;

public interface UserDao extends Repository<User, Integer> {
    User findByUsername(String username);
}

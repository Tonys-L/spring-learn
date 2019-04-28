package com.lt.spring.security;

import com.lt.spring.security.dao.UserDao;
import com.lt.spring.security.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    private UserDao userDao;

    public CustomUserDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(123321);
        User user = userDao.findByUsername(username);
        System.out.println(user);
        return new CustomUserDetails(user);
    }
}

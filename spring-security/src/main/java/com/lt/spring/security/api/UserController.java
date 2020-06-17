package com.lt.spring.security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	// 资源API
    @RequestMapping("/api/userinfo")
    public ResponseEntity getUserInfo(HttpServletRequest httpServletRequest) {
        Object obj = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        return ResponseEntity.ok(obj);
    }

}
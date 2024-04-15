package com.medisure.medisure_as.controller;

import com.medisure.medisure_as.entity.User;
import com.medisure.medisure_as.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String createA(){
        User user = new User();
        user.setActived(1);
        user.setCreated_date(new Timestamp(System.currentTimeMillis()));
        user.setEmail("admin@gmail.com");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setUsername("admin");
        userRepository.save(user);
        return "index";
    }
}

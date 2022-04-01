package com.proyecto_componentes.web;

import com.proyecto_componentes.domain.User;
import com.proyecto_componentes.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    @Autowired
    UserService userService;
    
    @GetMapping({"/","/login"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping({"/products"})
    public String products(Model model) {
        return "products";
    }

    @GetMapping({"/signin"})
    public String signin(Model model) {
        return "signin";
    }

    @CrossOrigin
    @PostMapping("/api/signin")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = new User(user.getUsername(), user.getPassword(),
                user.getNombre(), user.getApellidos(), true);
        userService.registerUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}

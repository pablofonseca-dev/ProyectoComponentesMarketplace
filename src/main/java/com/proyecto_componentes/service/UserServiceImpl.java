package com.proyecto_componentes.service;

import com.proyecto_componentes.domain.User;
import com.proyecto_componentes.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    
    @Override
    public void registerUser(User user) {
        userRepository.save(user);
        
    }
    
}

package com.github.healthbet.api.service;


import com.github.healthbet.api.dto.UserRequestCreate;
import com.github.healthbet.api.dto.UserRequestUpdate;
import com.github.healthbet.api.model.User;
import com.github.healthbet.api.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> update(Long id,
                                UserRequestUpdate dto) {
        return userRepository.findById(id)
                    .map(user -> {
                        user.setName(dto.getName());
                        user.setEmail(dto.getEmail());
                        user.setPhone(dto.getPhone());
                        user.setBirthdate(dto.getBirthdate());
                        return userRepository.save(user);
                    });
    }

    public User save(UserRequestCreate dto) {
                
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setBirthdate(dto.getBirthdate());
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    } 
    
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public boolean deleteById(Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


}

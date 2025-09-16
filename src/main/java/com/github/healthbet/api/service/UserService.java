package com.github.healthbet.api.service;

import com.github.healthbet.api.dto.UserRequestCreate;
import com.github.healthbet.api.dto.UserRequestUpdate;
import com.github.healthbet.api.model.User;
import com.github.healthbet.api.repository.UserRepository;
import com.github.healthbet.api.exception.BadRequestException;
import com.github.healthbet.api.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(UserRequestCreate dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new BadRequestException("E-mail já cadastrado.");
        }
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setBirthdate(dto.getBirthdate());
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public Optional<User> update(Long id, UserRequestUpdate dto) {
        return userRepository.findById(id)
            .map(user -> {
                if (dto.getEmail() != null && !dto.getEmail().equals(user.getEmail())) {
                    if (userRepository.existsByEmail(dto.getEmail())) {
                        throw new BadRequestException("E-mail já utilizado por outro usuário.");
                    }
                    user.setEmail(dto.getEmail());
                }
                if (dto.getName() != null) user.setName(dto.getName());
                if (dto.getPhone() != null) user.setPhone(dto.getPhone());
                if (dto.getBirthdate() != null) user.setBirthdate(dto.getBirthdate());
                return userRepository.save(user);
            });
    }

    @Transactional
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário não encontrado com id: " + id);
        }
        userRepository.deleteById(id);
    }
}

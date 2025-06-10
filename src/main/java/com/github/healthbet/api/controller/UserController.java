package com.github.healthbet.api.controller;

import com.github.healthbet.api.dto.UserRequestCreate;
import com.github.healthbet.api.dto.UserRequestUpdate;
import com.github.healthbet.api.dto.UserResponse;
import com.github.healthbet.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    // Criar usuário
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequestCreate dto) {
        return ResponseEntity.status(201).body(
                new UserResponse().toDto(userService.save(dto))
                );
    }

    // Buscar todos usuários
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(userService
            .findAll()
            .stream()
            .map(user -> new UserResponse().toDto(user))
            .collect(Collectors.toList()));
    }
    

    @PutMapping("{id}")
    public ResponseEntity<UserResponse> update(
				@PathVariable Long id, 
				@RequestBody UserRequestUpdate dto) {
               
        return userService.update(id, dto)
                    .map(user -> ResponseEntity.ok(new UserResponse().toDto(user)))                  
                    .orElse(ResponseEntity.notFound().build());        
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {         
        return userService.findById(id)
            .map(user -> ResponseEntity.ok(new UserResponse().toDto(user)))
            .orElse(ResponseEntity.notFound().build());        
    }

    // (Opcional) Deletar usuário
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = userService.deleteById(id);

        if (result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }        
    }
}
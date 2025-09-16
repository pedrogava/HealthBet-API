package com.github.healthbet.api.controller;

import com.github.healthbet.api.dto.*;
import com.github.healthbet.api.service.UserService;
import com.github.healthbet.api.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequestCreate dto) {
        User saved = userService.save(dto);
        URI location = URI.create(String.format("/users/%d", saved.getId()));
        return ResponseEntity.created(location).body(UserResponse.fromEntity(saved));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> list = userService.findAll()
            .stream()
            .map(UserResponse::fromEntity)
            .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return userService.findById(id)
            .map(user -> ResponseEntity.ok(UserResponse.fromEntity(user)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id,
                                               @Valid @RequestBody UserRequestUpdate dto) {
        return userService.update(id, dto)
            .map(user -> ResponseEntity.ok(UserResponse.fromEntity(user)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteById(id); // lança ResourceNotFoundException se não existir
        return ResponseEntity.noContent().build();
    }
}

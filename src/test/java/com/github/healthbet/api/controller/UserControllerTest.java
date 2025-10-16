package com.github.healthbet.api.controller;

import com.github.healthbet.api.ApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value; // ⬅️ IMPORTAR Value
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders; // ⬅️ IMPORTAR MockMvcRequestBuilders

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user; // ⬅️ IMPORTAR SecurityMockMvcRequestPostProcessors.user
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ApiApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.username=rm551043", // Valor que você quer usar
        "spring.datasource.password=060505"
})
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // 1. Injeta o valor da propriedade na variável
    @Value("${spring.datasource.username}")
    private String configuredUsername;

    @Test
        // ⬅️ Removido @WithMockUser
    void shouldReturnAllUsers() throws Exception {
        // 2. Simula o usuário de forma programática usando a variável injetada
        mockMvc.perform(get("/users")
                        .with(user(configuredUsername).roles("USER"))) // Usa "rm551043" como username
                .andExpect(status().isOk());
    }
}
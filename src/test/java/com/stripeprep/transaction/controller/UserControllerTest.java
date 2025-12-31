package com.stripeprep.transaction.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;



    // ---------- TEST 1: VALID USER CREATION ----------
    @Test
    void shouldCreateUser_whenInputIsValid() throws Exception {
        String requestBody = """
                {
                  "name": "Shreya",
                  "email": "shreya@gmail.com"
                }
                """;

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.name").value("Shreya"))
                .andExpect(jsonPath("$.email").value("shreya@gmail.com"));
    }

    // ---------- TEST 2: INVALID USER INPUT ----------
    @Test
    void shouldReturnBadRequest_whenInputIsInvalid() throws Exception {
        String invalidRequestBody = """
                {
                  "name": "",
                  "email": "abc"
                }
                """;

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidRequestBody))
                .andExpect(status().isBadRequest());
    }

    // ---------- TEST 3: USER NOT FOUND ----------
    @Test
    void shouldReturnNotFound_whenUserDoesNotExist() throws Exception {
        mockMvc.perform(get("/users/999"))
                .andExpect(status().isNotFound());
    }
}

package com.mib.service2.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DocumentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void debeResponder200EnPost() throws Exception {
        mockMvc.perform(post("/api/documento"))
                .andExpect(status().isOk());
    }
}
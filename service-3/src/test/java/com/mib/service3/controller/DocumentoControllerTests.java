package com.mib.service3.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class DocumentoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void debeAceptarJsonPorPost() throws Exception {
        String json = """
        {
          "ndoc": 1,
          "cantdoc": 20,
          "documento": "UEZGZmFrZQ==",
          "metadata": {
            "fecha": "2026-01-01",
            "organismo": "economia"
          },
          "estado": true,
          "codigo": 0
        }
        """;

        mockMvc.perform(
                post("/api/documentosFirmados")
                        .contentType("application/json")
                        .content(json)
        ).andExpect(status().isOk());
    }
}

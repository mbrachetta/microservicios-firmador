package com.mib.service4.controller;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mib.service4.service.ReporteFileService;


@WebMvcTest(LoteController.class)
class LoteControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReporteFileService reporteFileService;

    @Test
    void debeAceptarJsonPorPost() throws Exception {
        mockMvc.perform(post("/api/lotes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"filtro\":\"12345\",\"cantdoc\":4,\"cantrecibidos\":4,\"cantprocesados\":4,\"cantfirmados\":3,\"cantfallaron\":1,\"cantenviados\":4,\"resumenlote\":[{\"ndoc\":1,\"status\":true,\"errorcode\":\"sin error\"},{\"ndoc\":2,\"status\":true,\"errorcode\":\"sin error\"},{\"ndoc\":3,\"status\":true,\"errorcode\":\"sin error\"},{\"ndoc\":4,\"status\":false,\"errorcode\":\"ERROR 037 Error general al firmar el documento\"}]}"
                        ))
                .andExpect(status().isOk())
                .andExpect(content().string("Reporte recibido correctamente"));
    }
}

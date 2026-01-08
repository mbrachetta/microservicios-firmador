package com.mib.service2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


import com.mib.service2.dto.DocumentoResponse;
import com.mib.service2.service.DocumentoService;

@RestController
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping("/api/documento")
    public DocumentoResponse obtenerDocumento() {
        return documentoService.generarDocumento();
    }
}

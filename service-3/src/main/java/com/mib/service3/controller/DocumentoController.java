package com.mib.service3.controller;

import com.mib.service3.dto.DocumentoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Base64;

@RestController
public class DocumentoController {

    private final Path outputDir;

    public DocumentoController(@Value("${app.output-dir}") String outputDir) {
        System.out.println("OUTPUT DIR CONFIG = " + outputDir);
        this.outputDir = Paths.get(outputDir);
    }

    @PostMapping("/api/documentosFirmados")
    public ResponseEntity<String> recibirDocumento(@RequestBody DocumentoRequest request) {

        try {
            Files.createDirectories(outputDir);
            int ndoc = request.getNdoc();
            if (request.isEstado() && request.getCodigo() == 0) {
                guardarPdf(request);
                return ResponseEntity.ok("Documento guardado correctamente");
            } else {
                guardarLog(request);
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Documento rechazado");
            }
        } catch (Exception e) {
            e.printStackTrace(); // <-- CLAVE
            return ResponseEntity.internalServerError()
                    .body("Error procesando el documento: " + e.getMessage());
        }
    }

    private void guardarPdf(DocumentoRequest request) throws Exception {

        Files.createDirectories(outputDir);

        byte[] pdfBytes = Base64.getDecoder().decode(request.getDocumento());

        Path filePath = outputDir.resolve("doc" + request.getNdoc() + ".pdf");
        Files.write(filePath, pdfBytes);
    }

    private void guardarLog(DocumentoRequest request) throws Exception {

        Files.createDirectories(outputDir);

        String contenido = "El documento no pudo firmarse. Código: " + request.getCodigo();

        Path filePath = outputDir.resolve("log" + request.getNdoc() + ".txt");
        Files.write(filePath, contenido.getBytes(StandardCharsets.UTF_8));
    }
}

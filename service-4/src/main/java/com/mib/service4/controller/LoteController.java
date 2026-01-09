package com.mib.service4.controller;

import com.mib.service4.dto.LoteRequest;
import com.mib.service4.service.ReporteFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {

    private final ReporteFileService reporteFileService;
    private static final Logger log = LoggerFactory.getLogger(ReporteFileService.class);

    public LoteController(ReporteFileService reporteFileService) {
        this.reporteFileService = reporteFileService;
    }

    @PostMapping
    public ResponseEntity<String> recibirLote(@RequestBody LoteRequest request) {
        try {
            System.out.println("ENTRÓ AL CONTROLLER");
            log.info("generarReporte ejecutado");

            reporteFileService.generarReporte(request);
            return ResponseEntity.ok("Reporte recibido correctamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error al recibir reporte: " + e.getMessage());
        }
    }
}

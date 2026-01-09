package com.mib.service4.controller;

import com.mib.service4.dto.LoteRequest;
import com.mib.service4.service.ReporteFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {

    private final ReporteFileService reporteFileService;

    public LoteController(ReporteFileService reporteFileService) {
        this.reporteFileService = reporteFileService;
    }

    @PostMapping
    public ResponseEntity<String> recibirLote(@RequestBody LoteRequest request) {
        try {
            reporteFileService.generarReporte(request);
            return ResponseEntity.ok("Reporte generado correctamente");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error generando reporte: " + e.getMessage());
        }
    }
}

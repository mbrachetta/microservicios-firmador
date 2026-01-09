package com.mib.service4.service;

import com.mib.service4.dto.LoteRequest;
import com.mib.service4.dto.ResumenDocumento;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ReporteFileService {

    @Value("${app.output-dir}")
    private String outputDir;

    public void generarReporte(LoteRequest lote) throws IOException {

        System.out.println("el outputDir es: " + outputDir);

        Path dir = Paths.get(outputDir);
        Files.createDirectories(dir); // crea output/ si no existe

        String ts = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        Path archivo = dir.resolve("reporte_" + ts + ".txt");

        StringBuilder sb = new StringBuilder();

        sb.append("REPORTE DE LOTE\n");
        sb.append("========================\n");
        sb.append("Filtro: ").append(lote.getFiltro()).append("\n");
        sb.append("Cant. documentos: ").append(lote.getCantdoc()).append("\n");
        sb.append("Recibidos: ").append(lote.getCantrecibidos()).append("\n");
        sb.append("Procesados: ").append(lote.getCantprocesados()).append("\n");
        sb.append("Firmados: ").append(lote.getCantfirmados()).append("\n");
        sb.append("Fallaron: ").append(lote.getCantfallaron()).append("\n");
        sb.append("Enviados: ").append(lote.getCantenviados()).append("\n\n");

        sb.append("DETALLE POR DOCUMENTO\n");
        sb.append("------------------------\n");

        for (ResumenDocumento doc : lote.getResumenlote()) {
            sb.append("Doc #").append(doc.getNdoc())
                    .append(" | Status: ").append(doc.isStatus())
                    .append(" | Error: ").append(doc.getErrorcode())
                    .append("\n");
        }
        Files.write(
                archivo,
                sb.toString().getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }
}

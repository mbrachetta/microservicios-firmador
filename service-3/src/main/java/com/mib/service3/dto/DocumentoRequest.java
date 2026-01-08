package com.mib.service3.dto;

import java.util.Map;

public class DocumentoRequest {

    private int ndoc;
    private int cantdoc;
    private String documento;
    private Map<String, String> metadata;
    private boolean estado;
    private int codigo;

    // getters y setters

    public int getNdoc() {
        return ndoc;
    }

    public void setNdoc(int ndoc) {
        this.ndoc = ndoc;
    }

    public int getCantdoc() {
        return cantdoc;
    }

    public void setCantdoc(int cantdoc) {
        this.cantdoc = cantdoc;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}

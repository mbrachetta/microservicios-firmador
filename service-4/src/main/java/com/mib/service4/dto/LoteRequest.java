package com.mib.service4.dto;

import java.util.List;

public class LoteRequest {

    private String filtro;
    private int cantdoc;
    private int cantrecibidos;
    private int cantprocesados;
    private int cantfirmados;
    private int cantfallaron;
    private int cantenviados;
    private List<ResumenDocumento> resumenlote;

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public int getCantdoc() {
        return cantdoc;
    }

    public void setCantdoc(int cantdoc) {
        this.cantdoc = cantdoc;
    }

    public int getCantrecibidos() {
        return cantrecibidos;
    }

    public void setCantrecibidos(int cantrecibidos) {
        this.cantrecibidos = cantrecibidos;
    }

    public int getCantprocesados() {
        return cantprocesados;
    }

    public void setCantprocesados(int cantprocesados) {
        this.cantprocesados = cantprocesados;
    }

    public int getCantfirmados() {
        return cantfirmados;
    }

    public void setCantfirmados(int cantfirmados) {
        this.cantfirmados = cantfirmados;
    }

    public int getCantfallaron() {
        return cantfallaron;
    }

    public void setCantfallaron(int cantfallaron) {
        this.cantfallaron = cantfallaron;
    }

    public int getCantenviados() {
        return cantenviados;
    }

    public void setCantenviados(int cantenviados) {
        this.cantenviados = cantenviados;
    }

    public List<ResumenDocumento> getResumenlote() {
        return resumenlote;
    }

    public void setResumenlote(List<ResumenDocumento> resumenlote) {
        this.resumenlote = resumenlote;
    }
}

package com.mib.service4.dto;

public class ResumenDocumento {

    private int ndoc;
    private boolean status;
    private String errorcode;

    public int getNdoc() {
        return ndoc;
    }

    public void setNdoc(int ndoc) {
        this.ndoc = ndoc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
}

package com.example.grupo3_app.Response;

public class RegisterResponse {
    private String mensajeRespuesta;
    private boolean acceso;
    private int sqlReturn;

    public RegisterResponse() {
    }

    public RegisterResponse(String mensajeRespuesta, boolean acceso, int sqlReturn) {
        this.mensajeRespuesta = mensajeRespuesta;
        this.acceso = acceso;
        this.sqlReturn = sqlReturn;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public boolean isAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }

    public int getSqlReturn() {
        return sqlReturn;
    }

    public void setSqlReturn(int sqlReturn) {
        this.sqlReturn = sqlReturn;
    }
}

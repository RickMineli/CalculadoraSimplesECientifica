package com.github.rickmineli.calculadoraapi.exception;

public class JSONInvalidoException extends RuntimeException {
    public JSONInvalidoException(String msg) {
        super("JSON Invalido, motivo: "+msg);
    }
}

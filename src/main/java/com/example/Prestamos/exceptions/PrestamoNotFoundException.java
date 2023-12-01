package com.example.Prestamos.exceptions;

public class PrestamoNotFoundException extends RuntimeException{
    public PrestamoNotFoundException(String mensaje) {
        super(mensaje);
    }
}

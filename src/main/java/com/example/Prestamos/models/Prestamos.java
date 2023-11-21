package com.example.Prestamos.models;

import jakarta.persistence.Entity;

@Entity
public class Prestamos {
    private Long id;
    private String Titulo;
    private String Autor;
    private String FechaPrestamo;
    private String FechaDevolucion;

    public Prestamos(Long id, String titulo, String autor, String fechaPrestamo, String fechaDevolucion) {
        this.id = id;
        Titulo = titulo;
        Autor = autor;
        FechaPrestamo = fechaPrestamo;
        FechaDevolucion = fechaDevolucion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getFechaPrestamo() {
        return FechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        FechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        FechaDevolucion = fechaDevolucion;
    }
}


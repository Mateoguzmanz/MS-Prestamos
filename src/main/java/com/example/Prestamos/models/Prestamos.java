package com.example.Prestamos.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Prestamos")
@Schema(description = "Prestamos que accede a la solucion")
public class Prestamos {
    @Id
    @Schema(description = "Id unico del prestamo, usualmente una identificacion con tipo", example = "C65437374")
    private Long id;
    @Schema(description = "Titulo del libro prestado", example = "Viaje al centro de la tierra")
    private String Titulo;
    @Schema(description = "Autor del libro prestado", example = "Gabriel Garcia Marquez")
    private String Autor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Schema(description = "Fecha del libro prestado", example = "2023-10-12")
    private String FechaPrestamo;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Schema(description = "Fecha Devolucion del libro prestado", example = "2024-10-1")
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


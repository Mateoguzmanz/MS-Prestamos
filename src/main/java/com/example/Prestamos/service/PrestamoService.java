package com.example.Prestamos.service;

import com.example.Prestamos.exceptions.PrestamoNotFoundException;
import com.example.Prestamos.models.Prestamos;
import com.example.Prestamos.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    @Autowired
    public PrestamoService(PrestamoRepository prestamoRepository){
        this.prestamoRepository = prestamoRepository;
    }

    public Flux<Prestamos> obtenerTodosLosPrestamos() {
        return prestamoRepository.findAll();
    }

    public Prestamos obtenerPorId(Long id) {
        return prestamoRepository.findById(id)
                .blockOptional().orElseThrow(() -> new PrestamoNotFoundException("Prestamo no encontrado con ID: " + id));
    }

    public ResponseEntity<String> crearPrestamo(Prestamos prestamos) {
        try {
            prestamoRepository.save(prestamos).subscribe();
            return ResponseEntity.status(HttpStatus.CREATED).body("Prestamo creado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear prestamo");
        }
    }

    public Mono<Prestamos> actualizarPrestamo(Long id, Prestamos prestamoActualizado) {
        return prestamoRepository.findById(id).flatMap(prestamoActual -> {
            prestamoActual.setFechaPrestamo(prestamoActualizado.getFechaPrestamo());
            prestamoActual.setFechaDevolucion(prestamoActualizado.getFechaDevolucion());
            return prestamoRepository.save(prestamoActual);
        });
    }

    public Mono<Void> eliminarPrestamo(Long id) {
        Prestamos prestamo = obtenerPorId(id);
        return prestamoRepository.delete(prestamo);
    }

}


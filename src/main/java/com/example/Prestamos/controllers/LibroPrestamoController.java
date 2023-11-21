package com.example.Prestamos.controllers;

import com.example.Prestamos.models.Prestamos;
import com.example.Prestamos.repositories.PrestamoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/prestamos")
public class LibroPrestamoController {
    private PrestamoRepository prestamoRepository;

    @GetMapping("/actuator/health")
    public String health(){
        return "OK";
    }

    @GetMapping("/actuator/metrics")
    public String metrics(){
        return "Metrics";
    }

    @GetMapping("/actuator/info")
    public String info() {
        return "info";
    }



    @GetMapping
    public Flux<Prestamos> obtenerTodosLosPrestamos() {
        return prestamoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> crearPrestamo(@RequestBody Prestamos prestamo) {
        try {
            Mono<Prestamos> nuevoPrestamo = prestamoRepository.save(prestamo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear prestamo");
        }
        return null;
    }

    @PutMapping
    public Mono<Prestamos> actualizarPrestamo(@PathVariable Long id, @RequestBody Prestamos prestamos) {
        return prestamoRepository.findById(id).flatMap(prestamoActual -> {
            prestamoActual.setFechaPrestamo(prestamos.getFechaPrestamo());
            prestamoActual.setFechaDevolucion(prestamoActual.getFechaDevolucion());
            return prestamoRepository.save(prestamoActual);
        });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarPrestamo(@PathVariable Long id) {
        return prestamoRepository.deleteById(id);
    }

}

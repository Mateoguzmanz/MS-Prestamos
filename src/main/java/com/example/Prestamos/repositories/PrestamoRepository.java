package com.example.Prestamos.repositories;

import com.example.Prestamos.models.Prestamos;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends ReactiveCrudRepository<Prestamos, Long> {
}

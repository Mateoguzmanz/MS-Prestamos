package com.example.Prestamos.repositories;

import com.example.Prestamos.models.Prestamos;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends R2dbcRepository<Prestamos, Long> {
}

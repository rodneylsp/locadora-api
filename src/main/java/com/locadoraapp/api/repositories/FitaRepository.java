package com.locadoraapp.api.repositories;

import com.locadoraapp.api.domain.fita.Fita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FitaRepository extends JpaRepository<Fita, UUID> {
}

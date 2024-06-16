package com.locadoraapp.api.repositories;

import com.locadoraapp.api.domain.aluguel.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AluguelRepository extends JpaRepository<Aluguel, UUID> {
}

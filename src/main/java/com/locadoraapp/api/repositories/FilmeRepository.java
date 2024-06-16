package com.locadoraapp.api.repositories;

import com.locadoraapp.api.domain.filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FilmeRepository extends JpaRepository<Filme, UUID> {
}

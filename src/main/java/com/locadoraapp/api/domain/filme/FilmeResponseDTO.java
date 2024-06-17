package com.locadoraapp.api.domain.filme;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

public record FilmeResponseDTO(UUID id, String titulo, String genero, String sinopse, Date lancamento, String imagemURL) {
}

package com.locadoraapp.api.domain.filme;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public record FilmeRequestDTO(String titulo, String genero, String sinopse, Long lancamento, MultipartFile imagem) {
}

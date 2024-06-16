package com.locadoraapp.api.controller;

import com.locadoraapp.api.domain.filme.Filme;
import com.locadoraapp.api.domain.filme.FilmeRequestDTO;
import com.locadoraapp.api.service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/filme")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Filme> create(@RequestParam("titulo") String titulo,
                                        @RequestParam("genero") String genero,
                                        @RequestParam("sinopse") String sinopse,
                                        @RequestParam("lancamento") Long lancamento,
                                        @RequestParam("imagem") MultipartFile imagem){
        FilmeRequestDTO filmeRequestDTO = new FilmeRequestDTO(titulo, genero, sinopse, lancamento, imagem);
        Filme newFilme = this.filmeService.createFilme(filmeRequestDTO);
        return ResponseEntity.ok(newFilme);
    }


}

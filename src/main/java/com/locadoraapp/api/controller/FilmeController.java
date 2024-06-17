package com.locadoraapp.api.controller;

import com.locadoraapp.api.domain.filme.Filme;
import com.locadoraapp.api.domain.filme.FilmeRequestDTO;
import com.locadoraapp.api.domain.filme.FilmeResponseDTO;
import com.locadoraapp.api.service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<FilmeResponseDTO>> getFilmes(@RequestParam(defaultValue = "0") int pagina,
                                                            @RequestParam(defaultValue = "2") int tamanho){
        List<FilmeResponseDTO> filmes = this.filmeService.getFilmes(pagina, tamanho);
        return ResponseEntity.ok(filmes);
    }


}

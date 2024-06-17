package com.locadoraapp.api.service;

import com.amazonaws.services.s3.AmazonS3;
import com.locadoraapp.api.domain.filme.Filme;
import com.locadoraapp.api.domain.filme.FilmeRequestDTO;
import com.locadoraapp.api.domain.filme.FilmeResponseDTO;
import com.locadoraapp.api.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class FilmeService {

    @Value("${aws.bucket.name}")
    private String awsBucket;
    private final AmazonS3 s3Client;

    private final FilmeRepository filmeRepository;

    public FilmeService(AmazonS3 s3Client, FilmeRepository filmeRepository) {
        this.s3Client = s3Client;
        this.filmeRepository = filmeRepository;
    }

    public Filme createFilme(FilmeRequestDTO data){

        String imgUrl = null;
        if(data.imagem() != null){
            imgUrl = this.uploadImage(data.imagem());
        }

        Filme newFilme = new Filme();
        newFilme.setTitulo(data.titulo());
        newFilme.setGenero(data.genero());
        newFilme.setSinopse(data.sinopse());
        newFilme.setLancamento(new Date(data.lancamento()));
        newFilme.setImagemURL(imgUrl);

        filmeRepository.save(newFilme);

        return newFilme;
    }

    private String uploadImage(MultipartFile multipartFile){

        String imageName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        try{
            File file = this.convertMultipartToFile(multipartFile);
            s3Client.putObject(awsBucket, imageName, file);
            file.delete();
            return s3Client.getUrl(awsBucket, imageName).toString();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao subir arquivo");
            return "";
        }
    }

    private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {

        File convertedFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convertedFile);
        fos.write(multipartFile.getBytes());
        fos.close();

        return convertedFile;
    }

    public List<FilmeResponseDTO> getFilmes(int pagina, int tamanho) {

        Pageable pageable = PageRequest.of(pagina, tamanho);
        Page<Filme> filmesPage = filmeRepository.findAll(pageable);
        return filmesPage.map(filme -> new FilmeResponseDTO(filme.getId(), filme.getTitulo(), filme.getGenero(),
                filme.getSinopse(), filme.getLancamento(), filme.getImagemURL()))
                .stream().toList();
    }
}

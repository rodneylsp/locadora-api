package com.locadoraapp.api.domain.filme;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "filme")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Filme {

    @Id
    @GeneratedValue
    private UUID id;

    private String titulo;
    private String genero;
    private String sinopse;
    private Date lancamento;
    private String imagemURL;
}

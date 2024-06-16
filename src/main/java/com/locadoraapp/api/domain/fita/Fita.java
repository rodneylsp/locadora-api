package com.locadoraapp.api.domain.fita;

import com.locadoraapp.api.domain.filme.Filme;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "fita")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fita {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "filme_id")
    private Filme filme;
}

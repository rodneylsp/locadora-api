package com.locadoraapp.api.domain.aluguel;

import com.locadoraapp.api.domain.fita.Fita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name = "aluguel")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToMany()
    @JoinTable(name = "aluguel_fita",
            joinColumns = {@JoinColumn(name = "aluguel_id")},
            inverseJoinColumns = {@JoinColumn(name = "fita_id")})
    private List<Fita> fitas;
    private Double total;
}

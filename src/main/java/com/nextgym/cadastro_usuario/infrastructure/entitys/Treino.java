package com.nextgym.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@Table(name = "treino")
@Entity

public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Gerar o Id automaticamente.
    private Integer id;

    @Column(name = "nome_treino")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "carga_kg")
    private Double cargaKg;
}

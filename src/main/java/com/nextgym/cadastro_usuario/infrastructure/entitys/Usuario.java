package com.nextgym.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; //Anotação que indica que o valor da chave primária será gerado automaticamente pelo banco de dados ou pelo provedor JPA
import jakarta.persistence.GenerationType; //Enum que define como esse valor será gerado. Os tipos principais são:
import jakarta.persistence.Id; //Anotação que indica que o campo é a chave primária da entidade.
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//Obter informações de um objeto, como seus atributos e métodos, e permitir que esses dados sejam acessados de forma segura e controlada.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "usuario")
@Entity
public class Usuario {
    @Id //marca o campo como chave primária
    @GeneratedValue(strategy = GenerationType.AUTO) //Gerar o Id automaticamente.
    private Integer id;

    @Column(name = "email", unique = true) //unique, não gera duplicidade de e-mails.
    private String email;

    @Column(name = "nome")
    private String nome;
    
}

//Se for trocar o nome da tabela e os atributos, tipo email e nome, é só trocar o nome do atributo name na anotação @Table.

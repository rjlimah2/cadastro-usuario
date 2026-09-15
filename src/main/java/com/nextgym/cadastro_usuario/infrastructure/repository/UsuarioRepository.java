package com.nextgym.cadastro_usuario.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nextgym.cadastro_usuario.infrastructure.entitys.Usuario;

import jakarta.transaction.Transactional; //Anotação que indica que o método deve ser executado dentro de uma transação, garantindo a consist

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> { //Usuario é a classe em usuario.java e Integer é o tipo do id da classe Usuario.
    // Interface que define os métodos de acesso aos dados do usuário no banco de dados.
    // Pode incluir métodos como salvar, atualizar, deletar e buscar usuários.

    // Retorno de usuario
    Optional<Usuario> findByEmail(String email); // Método para buscar um usuário pelo email. Email tem que corresponder ao mesmo nome do atributo na classe Usuario.java.

    @Transactional //Anotação que indica que o método deve ser executado dentro de uma transação, garantindo a consistência dos dados.
    void deleteByEmail(String email); 
}
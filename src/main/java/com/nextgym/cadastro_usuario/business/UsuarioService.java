package com.nextgym.cadastro_usuario.business;

import org.springframework.stereotype.Service;

import com.nextgym.cadastro_usuario.infrastructure.entitys.Usuario;
import com.nextgym.cadastro_usuario.infrastructure.repository.UsuarioRepository;



@Service //Anotação que indica que a classe é um serviço do Spring, responsável por conter a lógica de negócio da aplicação.
public class UsuarioService {
    
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    //Metodo de salvar usuario
    public void salvaUsuario(Usuario usuario){
        repository.saveAndFlush(usuario); //Salva o usuario no banco de dados e fecha a conexão.
    }

    //Metodo buscar usuario
    public Usuario buscaUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("Email não encontrado")
        );
    }

    //Metodo deleta usuario por email
    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    //Metodo atualizar usuario por id, sem precisar excluir o usuario inteiro, apenas os atributos que deseja atualizar.
    public void atualizarUsuarioPorId(Integer id, Usuario usuario){
        //Busca o usuário existente pelo email
        Usuario usuarioEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
        .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
        .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
        .id(usuarioEntity.getId())
        .build();

        repository.saveAndFlush(usuarioAtualizado); //Salva o usuario atualizado no banco de dados e fecha a conexão.
    }
}
    //Se precisar acrescentar um telefone ou outro atributo, é só acrescentar na classe Usuario.java e depois acrescentar aqui no metodo atualizarUsuarioPorId.
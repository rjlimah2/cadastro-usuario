package com.nextgym.cadastro_usuario.business;

import com.nextgym.cadastro_usuario.infrastructure.entitys.Treino;
import com.nextgym.cadastro_usuario.infrastructure.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TreinoService {
    private final TreinoRepository repository;

    public TreinoService(TreinoRepository repository) {
        this.repository = repository;
    }

    public Treino salvarTreino(Treino treino) {
        return repository.save(treino);
    }

    public List<Treino> buscarTodosTreinos() {
        return repository.findAll();
    }

    public Treino buscarTreinoPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));
    }

    public void deletarTreino(Integer id) {
        repository.deleteById(id);
    }

    public Treino atualizarTreino(Integer id, Treino treinoAtualizado) {
        Treino treinoExistente = buscarTreinoPorId(id);
        
        treinoExistente.setNome(treinoAtualizado.getNome());
        treinoExistente.setDescricao(treinoAtualizado.getDescricao());
        treinoExistente.setCargaKg(treinoAtualizado.getCargaKg());
        
        return repository.save(treinoExistente);
    }
}

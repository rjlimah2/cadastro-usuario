package com.nextgym.cadastro_usuario.controller;

import com.nextgym.cadastro_usuario.business.TreinoService;
import com.nextgym.cadastro_usuario.infrastructure.entitys.Treino;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")

public class TreinoController {
    private final TreinoService service;

    public TreinoController(TreinoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Treino> salvar(@RequestBody Treino treino) {
        return ResponseEntity.ok(service.salvarTreino(treino));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Treino>> listarTodos() {
        return ResponseEntity.ok(service.buscarTodosTreinos());
    }

    @GetMapping
    public ResponseEntity<Treino> buscarPorId(@RequestParam Integer id) {
        return ResponseEntity.ok(service.buscarTreinoPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@RequestParam Integer id) {
        service.deletarTreino(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarTreino(@RequestParam Integer id, @RequestBody Treino treino) {
        service.atualizarTreino(id, treino);
        return ResponseEntity.ok().build();
    }
}

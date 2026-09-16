package com.nextgym.cadastro_usuario.infrastructure.repository;

import com.nextgym.cadastro_usuario.infrastructure.entitys.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoRepository extends JpaRepository<Treino, Integer> {
    
}

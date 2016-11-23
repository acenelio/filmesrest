package com.nelioalves.filmes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.filmes.dominio.Participacao;

@Repository
public interface ParticipacaoRepositorio extends JpaRepository<Participacao, Integer> {

}


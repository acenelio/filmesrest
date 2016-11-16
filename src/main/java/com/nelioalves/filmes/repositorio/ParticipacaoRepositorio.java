package com.nelioalves.filmes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelioalves.filmes.dominio.Participacao;

public interface ParticipacaoRepositorio extends JpaRepository<Participacao, Integer> {

}


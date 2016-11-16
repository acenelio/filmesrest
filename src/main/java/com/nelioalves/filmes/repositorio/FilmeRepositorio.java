package com.nelioalves.filmes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelioalves.filmes.dominio.Filme;

public interface FilmeRepositorio extends JpaRepository<Filme, Integer> {

}


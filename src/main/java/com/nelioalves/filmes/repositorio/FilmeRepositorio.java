package com.nelioalves.filmes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.filmes.dominio.Filme;

@Repository
public interface FilmeRepositorio extends JpaRepository<Filme, Integer> {

}


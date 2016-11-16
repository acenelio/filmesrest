package com.nelioalves.filmes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nelioalves.filmes.dominio.Artista;

public interface ArtistaRepositorio extends JpaRepository<Artista, Integer> {

}


package com.nelioalves.filmes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.filmes.dominio.Artista;

@Repository
public interface ArtistaRepositorio extends JpaRepository<Artista, Integer>, ArtistaRepositorioCustom {

}


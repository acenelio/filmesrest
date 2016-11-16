package com.nelioalves.filmes.repositorio;

import java.util.List;

import com.nelioalves.filmes.dominio.Artista;

public interface ArtistaRepositorioCustom {

	public Artista buscarNomeExato(String nome);
	public List<Artista> buscarTodosOrdenadosPorNome();
	public List<Artista> buscarPorNome(String trecho);
}

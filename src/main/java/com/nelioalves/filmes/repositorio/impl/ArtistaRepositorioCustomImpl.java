package com.nelioalves.filmes.repositorio.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.nelioalves.filmes.dominio.Artista;
import com.nelioalves.filmes.repositorio.ArtistaRepositorioCustom;

@Component
public class ArtistaRepositorioCustomImpl implements ArtistaRepositorioCustom {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	public Artista buscarNomeExato(String nome) {
		String jpql = "SELECT x FROM Artista x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", nome);
		List<Artista> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Artista x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Artista> buscarPorNome(String trecho) {
		String jpql = "SELECT x FROM Artista x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
	}

}

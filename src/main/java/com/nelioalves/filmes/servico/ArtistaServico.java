package com.nelioalves.filmes.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.filmes.dominio.Artista;
import com.nelioalves.filmes.repositorio.ArtistaRepositorio;
import com.nelioalves.filmes.repositorio.ArtistaRepositorioCustom;
import com.nelioalves.filmes.servico.excecoes.NaoEncontradoException;
import com.nelioalves.filmes.servico.excecoes.ServicoException;
import com.nelioalves.filmes.servico.excecoes.ValidacaoException;

@Service
public class ArtistaServico {

	@Autowired
	private ArtistaRepositorio repo;

	@Autowired
	private ArtistaRepositorioCustom repoCustom;

	public void validar(Artista x) {
		List<String> erros = new ArrayList<>();
		
		if (x.getNome()==null) {
			erros.add("Favor preencher o campo nome");
		}
		if (x.getNacionalidade()==null) {
			erros.add("Favor preencher o campo nacionalidade");
		}
		if (x.getCache()==null) {
			erros.add("Favor preencher um valor válido para o cache");
		}
		if (x.getNascimento()==null) {
			erros.add("Favor preencher um valor válido para a data de nascimento");
		}
		
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}
	
	public Artista inserir(Artista x) throws ServicoException {
		Artista aux = repoCustom.buscarNomeExato(x.getNome());
		if (aux != null) {
			throw new ServicoException("Já existe um artista com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public Artista atualizar(Artista x) throws ServicoException {
		Artista aux = repo.findOne(x.getCodArtista());
		if (aux == null) {
			throw new NaoEncontradoException("Artista não encontrado!", 1);
		}
		aux = repoCustom.buscarNomeExato(x.getNome());
		if (aux != null && aux.getCodArtista()!=x.getCodArtista()) {
			throw new ServicoException("Já existe um outro artista com esse nome!", 1);
		}
		validar(x);
		return repo.save(x);
	}

	public void excluir(int cod) throws ServicoException {
		Artista art = repo.findOne(cod);
		if (art == null) {
			throw new NaoEncontradoException("Artista não encontrado!", 1);
		}
		if (!art.getParticipacoes().isEmpty()) {
			throw new ServicoException("Exclusão não permitida: este artista possui participações!", 2);
		}
		repo.delete(art);
	}
	
	public Artista buscar(int cod) {
		Artista art = repo.findOne(cod);
		if (art == null) {
			throw new NaoEncontradoException("Artista não encontrado!", 1);
		}
		return art;
	}
	
	public List<Artista> buscarTodosOrdenadosPorNome() {
		return repoCustom.buscarTodosOrdenadosPorNome();
	}
	
	public List<Artista> buscarPorNome(String trecho) {
		return repoCustom.buscarPorNome(trecho);
	}
}

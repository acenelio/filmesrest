package com.nelioalves.filmes.recursos;


import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.nelioalves.filmes.dominio.Artista;
import com.nelioalves.filmes.repositorio.ArtistaRepositorio;


@RestController
@RequestMapping("/artistas")
public class ArtistaRecurso {


	@Autowired
	private ArtistaRepositorio repo;


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Artista>> todos() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
		Artista art = repo.findOne(id);
		if (art == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(art);
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> criar(@RequestBody Artista artista) {
		artista = repo.save(artista);
		URI uri = getUri("/{id}", artista.getCodArtista());
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
		repo.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Artista artista, @PathVariable("id") Integer id) {
		artista.setCodArtista(id);
		repo.save(artista);
		return ResponseEntity.noContent().build();
	}
	
	private URI getUri(String nome, Integer valor) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path(nome).buildAndExpand(valor).toUri();
	}


}

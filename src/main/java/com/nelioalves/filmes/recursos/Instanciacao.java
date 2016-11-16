package com.nelioalves.filmes.recursos;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.filmes.dominio.Artista;
import com.nelioalves.filmes.dominio.Filme;
import com.nelioalves.filmes.dominio.Participacao;
import com.nelioalves.filmes.repositorio.ArtistaRepositorio;
import com.nelioalves.filmes.repositorio.FilmeRepositorio;
import com.nelioalves.filmes.repositorio.ParticipacaoRepositorio;

@RestController
@RequestMapping("/instanciacao")
public class Instanciacao {

	@Autowired
	private ArtistaRepositorio artistaRepo;
	
	@Autowired
	private FilmeRepositorio filmeRepo;
	
	@Autowired
	private ParticipacaoRepositorio participacaoRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public String executar() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			Filme f1 = new Filme(null, "O aviador", 170, 2005);
			Filme f2 = new Filme(null, "Titanic", 195, 1997);
			
			Artista a1 = new Artista(null, "Leonardo Di Caprio", "EUA", new BigDecimal("10000000.00"), sdf.parse("11/11/1974"));
			Artista a2 = new Artista(null, "Cate Blanchett", "Austrália", new BigDecimal("5000000.00"), sdf.parse("14/05/1969"));
			Artista a3 = new Artista(null, "Kate Winslet", "UK", new BigDecimal("8000000.00"), sdf.parse("05/10/1975"));

			Participacao p1 = new Participacao(null, "Jack Dawson", new BigDecimal("2000000.00"), f2, a1);
			Participacao p2 = new Participacao(null, "Howard Hughes", new BigDecimal("1000000.00"), f1, a1);
			Participacao p3 = new Participacao(null, "Rose Bukater", new BigDecimal("1000000.00"), f2, a3);
			Participacao p4 = new Participacao(null, "Katharine Hepburn", new BigDecimal("500000.00"), f1, a2);
			
			filmeRepo.save(f1);
			filmeRepo.save(f2);
			
			artistaRepo.save(a1);
			artistaRepo.save(a2);
			artistaRepo.save(a3);

			participacaoRepo.save(p1);
			participacaoRepo.save(p2);
			participacaoRepo.save(p3);
			participacaoRepo.save(p4);
		}
		catch (ParseException e) {
			return e.getMessage();
		}
		return "Pronto!";
	}
}

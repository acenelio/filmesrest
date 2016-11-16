package com.nelioalves.filmes.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_artista")
public class Artista implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codArtista;
	private String nome;
	private String nacionalidade;
	private BigDecimal cache;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	
	@OneToMany(mappedBy="artista")
	@JsonIgnore
	private List<Participacao> participacoes;
	
	public Artista() {
		participacoes = new ArrayList<>();
	}

	public Artista(Integer codArtista, String nome, String nacionalidade, BigDecimal cache, Date nascimento) {
		super();
		this.codArtista = codArtista;
		this.nome = nome;
		this.nacionalidade = nacionalidade;
		this.cache = cache;
		this.nascimento = nascimento;
		participacoes = new ArrayList<>();
	}

	public Integer getCodArtista() {
		return codArtista;
	}

	public void setCodArtista(Integer codArtista) {
		this.codArtista = codArtista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public BigDecimal getCache() {
		return cache;
	}

	public void setCache(BigDecimal cache) {
		this.cache = cache;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}
	
	public void addParticipacao(Participacao x) {
		this.participacoes.add(x);
		x.setArtista(this);
	}

	public void removeParticipacao(Participacao x) {
		this.participacoes.remove(x);
	}

	@Override
	public String toString() {
		return "Artista [codArtista=" + codArtista + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", cache="
				+ cache + ", nascimento=" + nascimento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codArtista == null) ? 0 : codArtista.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		if (codArtista == null) {
			if (other.codArtista != null)
				return false;
		} else if (!codArtista.equals(other.codArtista))
			return false;
		return true;
	}
	
}

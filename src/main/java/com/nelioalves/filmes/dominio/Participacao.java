package com.nelioalves.filmes.dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_participacao")
public class Participacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codParticipacao;
	private String personagem;
	private BigDecimal desconto;
	
	@ManyToOne
	@JoinColumn(name="filme")
	@JsonIgnore
	private Filme filme;
	
	@ManyToOne
	@JoinColumn(name="artista")
	@JsonIgnore
	private Artista artista;
	
	public Participacao() {
	}

	public Participacao(Integer codParticipacao, String personagem, BigDecimal desconto, Filme filme, Artista artista) {
		super();
		this.codParticipacao = codParticipacao;
		this.personagem = personagem;
		this.desconto = desconto;
		this.filme = filme;
		filme.addParticipacao(this);
		this.artista = artista;
		artista.addParticipacao(this);
	}

	public Integer getCodParticipacao() {
		return codParticipacao;
	}

	public void setCodParticipacao(Integer codParticipacao) {
		this.codParticipacao = codParticipacao;
	}

	public String getPersonagem() {
		return personagem;
	}

	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	@Override
	public String toString() {
		return "Participacao [codParticipacao=" + codParticipacao + ", personagem=" + personagem + ", desconto="
				+ desconto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codParticipacao == null) ? 0 : codParticipacao.hashCode());
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
		Participacao other = (Participacao) obj;
		if (codParticipacao == null) {
			if (other.codParticipacao != null)
				return false;
		} else if (!codParticipacao.equals(other.codParticipacao))
			return false;
		return true;
	}
	
	public BigDecimal getCachePago() {
		return artista.getCache().subtract(desconto);
	}
	
}

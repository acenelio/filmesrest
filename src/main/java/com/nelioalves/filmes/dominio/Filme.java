package com.nelioalves.filmes.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_filme")
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codFilme;
	private String titulo;
	private Integer duracao;
	private Integer ano;
	
	@OneToMany(mappedBy="filme")
	@JsonIgnore
	private List<Participacao> participacoes;

	public Filme() {
		participacoes = new ArrayList<>();
	}

	public Filme(Integer codFilme, String titulo, Integer duracao, Integer ano) {
		super();
		this.codFilme = codFilme;
		this.titulo = titulo;
		this.duracao = duracao;
		this.ano = ano;
		participacoes = new ArrayList<>();
	}

	public Integer getCodFilme() {
		return codFilme;
	}

	public void setCodFilme(Integer codFilme) {
		this.codFilme = codFilme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<Participacao> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<Participacao> participacoes) {
		this.participacoes = participacoes;
	}
	
	public void addParticipacao(Participacao x) {
		this.participacoes.add(x);
		x.setFilme(this);
	}

	public void removeParticipacao(Participacao x) {
		this.participacoes.remove(x);
	}

	@Override
	public String toString() {
		return "Filme [codFilme=" + codFilme + ", titulo=" + titulo + ", duracao=" + duracao + ", ano=" + ano + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codFilme == null) ? 0 : codFilme.hashCode());
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
		Filme other = (Filme) obj;
		if (codFilme == null) {
			if (other.codFilme != null)
				return false;
		} else if (!codFilme.equals(other.codFilme))
			return false;
		return true;
	}

	public BigDecimal getCacheTotal() {
		BigDecimal soma = new BigDecimal("0.00");
		for (Participacao p : participacoes) {
			soma = soma.add(p.getCachePago());
		}
		return soma;
	}
	
}

package com.nelioalves.filmes.recursos.handlers;

import java.util.ArrayList;
import java.util.List;

public class ErroRecurso {
	
	private Integer status;
	private String descricao;
	private List<String> mensagens;
	private Long timeStamp;
	
	public ErroRecurso(Integer status, String descricao, Long timeStamp) {
		super();
		this.status = status;
		this.descricao = descricao;
		this.timeStamp = timeStamp;
		setMensagens(new ArrayList<String>());
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}
}

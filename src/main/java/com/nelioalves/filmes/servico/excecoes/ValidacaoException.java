package com.nelioalves.filmes.servico.excecoes;

import java.util.List;

public class ValidacaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private List<String> erros;
	
	public ValidacaoException(String msg, List<String> erros) {
		super(msg);
		this.erros = erros;
	}
	
	public List<String> getErros() {
		return erros;
	}
}

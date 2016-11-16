package com.nelioalves.filmes.servico.excecoes;

public class NaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	
	public NaoEncontradoException(String msg, Integer codigo) {
		super(msg);
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
}
 
package com.bdq.model.entities;

public class Professor extends Usuario {

	public Professor(String nomeUsr, Integer idUsr, String cpf) {
		super(nomeUsr, idUsr, Boolean.FALSE, cpf);
	}
	
	public Professor() {}
}

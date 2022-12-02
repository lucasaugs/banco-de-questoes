package com.bdq.model.entities;

public class Aluno extends Usuario {
	
	private long matricula;

	public Aluno(String nomeUsr, Integer idUsr, long matricula, String cpf) {
		super(nomeUsr, idUsr, Boolean.TRUE, cpf);
		this.matricula = matricula;
	}

	public Aluno(){
	}

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	
	
}

package com.bdq.model.entities;

public class Usuario {
  private String nomeUsr;
  private Integer idUsr;
  private Boolean usrAluno;
  private String nome;
  private String senha;
  private String cpf;

  public Usuario(String nomeUsr, Integer idUsr, Boolean usrAluno, String cpf) {
    this.nomeUsr = nomeUsr;
    this.idUsr = idUsr;
    this.usrAluno = usrAluno;
    this.cpf = cpf;
  }

  public Usuario() {}

  public String getNomeUsr() {
    return nomeUsr;
  }

  public void setNomeUsr(String nomeUsr) {
    this.nomeUsr = nomeUsr;
  }

  public int getIdUsr() {
    return idUsr;
  }

  public void setIdUsr(int idUsr) {
    this.idUsr = idUsr;
  }

  public Boolean getUsrAluno() {
    return usrAluno;
  }

  public void setIdUsr(Integer idUsr) {
    this.idUsr = idUsr;
  }

  public void setUsrAluno(Boolean usrAluno) {
    this.usrAluno = usrAluno;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getCpf() {
	return cpf;
  }

  public void setCpf(String cpf) {
	this.cpf = cpf;
  }
}

package com.bdq.model.services;

import com.bdq.model.dao.AlunoDao;
import com.bdq.model.dao.DaoFactory;
import com.bdq.model.entities.Aluno;

public class Cadastro {
  public boolean checkNomeUsuario(String nomeUsr, Boolean isAluno) {
    AlunoDao alunoDao = DaoFactory.createAlunoDao();
    return alunoDao.checkByNomeUsr(nomeUsr) == null;

  }

  public static int cadastraAluno(Aluno aluno) {
    AlunoDao alunoDao = DaoFactory.createAlunoDao();
    return alunoDao.insert(aluno);
  }
}

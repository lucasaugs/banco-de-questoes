package com.bdq.model.services;

import com.bdq.model.dao.DaoFactory;
import com.bdq.model.dao.ProfessorDao;
import com.bdq.model.entities.Professor;

public class ProfessorServices {
	private final ProfessorDao dao = DaoFactory.createProfessorDao();
	
	public void insereProfessor(Professor obj) {
		dao.insert(obj);
	}
	
	public Professor pesquisaProfessorId(Professor obj) {
		return dao.findById(obj.getIdUsr());
	}
	public Professor pesquisaProfessorNomeUsrSenha(String nomeUsr, String senha) {
		return dao.findByNomeUsrSenha(nomeUsr, senha);
	}

	public void deletaPorId(Professor obj) {
		dao.deleteById(obj.getIdUsr());
	}

	public Boolean checaNomeUsuario(String nomeUsr) {
		return dao.checkByNomeUsr(nomeUsr);
	}
}

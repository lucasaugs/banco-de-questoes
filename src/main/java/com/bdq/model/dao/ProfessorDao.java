package com.bdq.model.dao;

import com.bdq.model.entities.Professor;

public interface ProfessorDao {
	void insert(Professor obj);
	void deleteById(Integer id);
	Professor findById(Integer id);
	Professor findByNomeUsrSenha(String nomeUsr, String senha);
	Boolean checkByNomeUsr(String nomeUsr);
}

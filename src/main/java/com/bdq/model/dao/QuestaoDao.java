package com.bdq.model.dao;

import com.bdq.model.entities.Questao;
import com.bdq.model.entities.Tema;

import java.util.List;

public interface QuestaoDao {
	void insert(Questao obj);
	void deleteById(Integer id);
	List<Questao> findByTemas(Tema tema, Boolean publica);
	void instanciaRelatorio(Questao obj);
	void instanciaTemas(Questao obj);
	void updateRelatorio(Questao obj);
	void insertRelatorio(Questao obj);
}

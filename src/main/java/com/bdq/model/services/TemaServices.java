package com.bdq.model.services;

import com.bdq.model.dao.DaoFactory;
import com.bdq.model.dao.TemaDao;
import com.bdq.model.entities.Tema;

import java.util.List;

public class TemaServices {
	private TemaDao dao = DaoFactory.createTemaDao();
	
	public void insereTema(Tema obj) {
		dao.insert(obj);
	}
	
	public Tema pesquisaTemaId(Tema obj) {
		return dao.findById(obj.getIdTema());
	}

	public Tema pesquisaTemaNome(String nome){
		return dao.findByNome(nome);
	}
	
	public void deletaPorId(Tema obj) {
		dao.deleteById(obj.getIdTema());
	}

	public List<Tema> todosTemas(){ return dao.findTemas();}
}

package com.bdq.model.services;

import com.bdq.model.dao.DaoFactory;
import com.bdq.model.dao.QuestaoDao;
import com.bdq.model.entities.Questao;
import com.bdq.model.entities.Tema;

import java.util.List;

public class BancoDeQuestoes {
	
	private QuestaoDao dao = DaoFactory.createQuestaoDao();
	
	public List<Questao> pesquisaQuestao(Tema tema, Boolean usrBoolean) {
		return dao.findByTemas(tema, usrBoolean);
	}
	
	public void insereQuestao(Questao questao) {
		dao.insert(questao);
	}
	
	public void insereOuAtualizaRelatorio(Questao questao) {
		if(questao.getRelatorio().getIdRel() == null)
			dao.insertRelatorio(questao);
		else dao.updateRelatorio(questao);
	}
	
	public static Double calculaMedia(List<Double> lista) {
		Double media = 0.0;
		for(Double item : lista) {
			media+=item;
		}
		media/=lista.size();
		return media;
	}
}

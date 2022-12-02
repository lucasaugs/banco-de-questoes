package com.bdq.model.dao;

import com.bdq.config.db.DB;
import com.bdq.model.dao.impl.AlunoDaoJDBC;
import com.bdq.model.dao.impl.ProfessorDaoJDBC;
import com.bdq.model.dao.impl.QuestaoDaoJDBC;
import com.bdq.model.dao.impl.TemaDaoJDBC;

public class DaoFactory {
	public static ProfessorDao createProfessorDao() {
		return new ProfessorDaoJDBC(DB.getConnection());
	}
	
	public static AlunoDao createAlunoDao() {
		return new AlunoDaoJDBC(DB.getConnection());
	}
	
	public static QuestaoDao createQuestaoDao() {
		return new QuestaoDaoJDBC(DB.getConnection());
	}
	
	public static TemaDao createTemaDao() {
		return new TemaDaoJDBC(DB.getConnection());
	}
}

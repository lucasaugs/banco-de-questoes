package com.bdq.unittests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bdq.model.entities.Aluno;
import com.bdq.model.entities.Professor;
import com.bdq.model.entities.Usuario;

public class UsuarioTest {

	@Test
	public void usuarioCadastradoNaoEAluno() {
		Usuario professor = new Professor("Professor", 555, "47970631061");
		assertFalse(professor.getUsrAluno());
	}
	
	@Test
	public void usuarioCadastradoEAluno() {
		Usuario aluno = new Aluno("Aluno", 555, 2018046, "47970631061");
		assertTrue(aluno.getUsrAluno());
	}

}

package com.bdq.unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bdq.model.entities.Questao;
import com.bdq.model.entities.Tema;

public class QuestaoTest {

    @Test
    public void questaoNaoPossuiTema() {
        List<Tema> temas = new ArrayList<>();
        Questao questao = new Questao(1, "enuciado", "resposta", true, temas);
        Tema tema = new Tema("Tema", 1);
        assertFalse(questao.questaoTemTema(tema));
    }

    @Test
    public void questaoPossuiTema() {
        Tema tema = new Tema("Tema", 1);
        List<Tema> temas = new ArrayList<>();
        temas.add(tema);
        Questao questao = new Questao(1, "enuciado", "resposta", true, temas);
        assertTrue(questao.questaoTemTema(tema));
    }
    
     @Test
    public void setQuestaoPublica() {
        Tema tema = new Tema("Tema", 1);
        List<Tema> temas = new ArrayList<>();
        temas.add(tema);
        Questao questao = new Questao(1, "enuciado", "resposta", false, temas);
        questao.setPublica(true);
        assertTrue(questao.questaoPublica());
    }
    
      @Test
     public void setEnunciadoPublica() {
        Tema tema = new Tema("Tema", 1);
        List<Tema> temas = new ArrayList<>();
        temas.add(tema);
        Questao questao = new Questao(1, "", "resposta", false, temas);
        
        questao.setEnunciado("teste");
        String enunciado = questao.getEnunciado();
        assertTrue(enunciado == "teste");
    }
}

package com.bdq.unittests;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bdq.model.services.BancoDeQuestoes;

public class BancoDeQuestoesTest {

	@Test
	public void calculaMedia() {
		List<Double> lista = new ArrayList<>() {
			{
				add(5.5);
				add(6.3);
				add(7.0);
			}
			
		};
		
		Double resultado = BancoDeQuestoes.calculaMedia(lista);
		assertEquals(6.27,resultado,0.01);
	}

}

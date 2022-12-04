package com.bdq.unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.bdq.model.services.util.CpfUtil;

public class CpfUtilTest{

	@Test
	public void cpfComTodosOsNumerosIguaisNaoEValido() {
		boolean resultado = CpfUtil.isCPF("99999999999");
		assertFalse(resultado);
	}
	
	@Test
	public void cpfComNumeroDeDigitosMenorQue11NaoEValido() {
		boolean resultado = CpfUtil.isCPF("63735298");
		assertFalse(resultado);
	}
	
	@Test
	public void cpfComNumeroDeDigitosMaiorQue11NaoEValido() {
		boolean resultado = CpfUtil.isCPF("6373529885472");
		assertFalse(resultado);
	}
	
	@Test
	public void cpfComCaracteresNaoNumericosNaoEValido() {
		boolean resultado = CpfUtil.isCPF("974BRA73598");
		assertFalse(resultado);
	}
	
	@Test
	public void cpfComoStringVaziaNaoEValido() {
		boolean resultado = CpfUtil.isCPF("");
		assertFalse(resultado);
	}
	
	@Test
	public void cpfValido() {
		boolean resultado = CpfUtil.isCPF("47970631061");
		assertTrue(resultado);
	}
	
	@Test
	public void imprimeCpfComPontosETraco() {
		String resultado = CpfUtil.imprimeCPF("47970631061");
		assertEquals("479.706.310-61",resultado);
	}

}

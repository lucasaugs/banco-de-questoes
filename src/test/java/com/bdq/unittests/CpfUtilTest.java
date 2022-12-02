package com.bdq.unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bdq.model.services.util.CpfUtil;

public class CpfUtilTest{

	@Test
	public void cpfComTodosOsNumerosIguaisNaoEValido() {
		boolean resultado = CpfUtil.isCPF("99999999999");
		assertFalse(resultado);
	}
	
	@Test
	public void cpfComNumeroDeDigitosDiferenteDe11NaoEValido() {
		boolean resultado = CpfUtil.isCPF("63735298");
		assertFalse(resultado);
	}
	
	@Test
	public void cpfComCaracteresNaoNumericosNaoEValido() {
		boolean resultado = CpfUtil.isCPF("974BRA73598");
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
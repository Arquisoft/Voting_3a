package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.dBUpdate.validate.DuplicateFieldValidation;
import es.uniovi.asw.dBUpdate.validate.EmailFieldValidation;
import es.uniovi.asw.dBUpdate.validate.EmptyFieldValidation;
import es.uniovi.asw.model.Voter;

public class ValidationTest {

	private Voter v1, v2, v3;
	
	@Before
	public void setUp() throws Exception {
		v1 = new Voter("nombre", "prueba@domain.com", "password", "", 234);
		v2 = new Voter("nombre", "pruebadomain.com", "password", "nif", 234);
		v3 = new Voter("nombre", "prueba@domaincom", "password", "nif", 234);
	}

	/**
	 * Metodo que comprueba la existencia de un NIF vacio
	 */
	@Test (expected = IllegalStateException.class)
	public void testEmptyNIFPositive() {
		EmptyFieldValidation efv = new EmptyFieldValidation();
		efv.validation(v1);
	}
	
	/**
	 * Metodo que comprueba la operacion negativa de comprobar un NIF vacio
	 */
	@Test
	public void testEmptyNIFNegative() {
		EmptyFieldValidation efv = new EmptyFieldValidation();
		efv.validation(v2);
		assertEquals(3, v2.getNif().trim().length());
	}
	
	/**
	 * Metodo que comprueba la existencia de un NIF duplicado
	 */
	@Test (expected = IllegalStateException.class)
	public void testDuplicateNIFPositive() {
		DuplicateFieldValidation dfv = new DuplicateFieldValidation();
		dfv.validation(v2);
		assertEquals("nif", v2.getNif());
		dfv.validation(v3);
		assertEquals("nif", v3.getNif());
	}
	
	/**
	 * Metodo que comprueba la operacion negativa de comprobar un NIF duplicado
	 */
	@Test
	public void testDuplicateNIFNegative() {
		DuplicateFieldValidation dfv = new DuplicateFieldValidation();
		dfv.validation(v1);
		assertEquals("", v1.getNif());
		dfv.validation(v3);
		assertEquals("nif", v3.getNif());
	}
	
	/**
	 * Metodo que comprueba la existencia de un email con formato correcto
	 */
	@Test 
	public void testEmailFieldPositive() {
		EmailFieldValidation efv = new EmailFieldValidation();
		efv.validation(v1);
		assertEquals("prueba@domain.com", v1.getEmail());
	}
	
	/**
	 * Metodo que comprueba la existencia de un email con formato incorrecto
	 * (falta el @)
	 */
	@Test (expected = IllegalStateException.class)
	public void testEmailFieldNegative1() {
		EmailFieldValidation efv = new EmailFieldValidation();
		efv.validation(v2);
		assertEquals("pruebadomain.com", v2.getEmail());
	}
	
	/**
	 * Metodo que comprueba la existencia de un email con formato incorrecto
	 * (falta el .)
	 */
	@Test (expected = IllegalStateException.class)
	public void testEmailFieldNegative2() {
		EmailFieldValidation efv = new EmailFieldValidation();
		efv.validation(v3);
		assertEquals("prueba@domaincom", v3.getEmail());
	}

}

/**
 * 
 */
package es.uniovi.asw.cobertura.modelo;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ComunidadAutonoma;

/**
 * @author Amir
 *
 */
public class ComunidadAutonomaTest {
	private ComunidadAutonoma ca;
	private String nombre1="ca1";
	private String nombre2="ca2";
	private Object o = null;
	

	/**
	 * Test method for {@link es.uniovi.asw.model.ComunidadAutonoma#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		ca = new ComunidadAutonoma(nombre1);
		assertEquals(98226,ca.hashCode());
		ca = new ComunidadAutonoma(null);
		assertEquals(31,ca.hashCode());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.ComunidadAutonoma#ComunidadAutonoma(java.lang.String)}.
	 */
	@Test
	public final void testComunidadAutonomaString() {
		ca = new ComunidadAutonoma(nombre1);
		assertEquals(nombre1, ca.getNombre());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.ComunidadAutonoma#setCircunscripciones(java.util.Set)}.
	 * as example
	 */
	@Test
	public final void testSets() {
		ca = new ComunidadAutonoma(nombre1);
		Set<Circunscripcion> s = new HashSet<Circunscripcion>();
		ca.setCircunscripciones(s);
		assertEquals(s, ca.getCircunscripciones());
		assertTrue(s==ca.getCircunscripciones());
				
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.ComunidadAutonoma#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		ca = new ComunidadAutonoma(nombre1);
		ComunidadAutonoma ca2 = new ComunidadAutonoma(nombre2);
		ComunidadAutonoma ca3 = new ComunidadAutonoma(nombre1);
		ComunidadAutonoma ca4 = new ComunidadAutonoma(null);
		
		assertTrue(ca.equals(ca));
		assertTrue(ca.equals(ca3));
		
		assertFalse(ca.equals(ca4));
		assertFalse(ca4.equals(ca));
		assertFalse(ca.equals(o));
		assertFalse(ca.equals(ca2));
		assertFalse(ca2.equals(ca));
		assertFalse(ca.equals("otra Clase"));
		
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.ComunidadAutonoma#toString()}.
	 */
	@Test
	public final void testToString() {
		ca = new ComunidadAutonoma(nombre1);
	
		assertEquals("ComunidadAutonoma [id=null, nombre=ca1]", ca.toString());
	}

}

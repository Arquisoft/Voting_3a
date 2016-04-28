/**
 * 
 */
package es.uniovi.asw.cobertura.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.ComunidadAutonoma;
import es.uniovi.asw.model.Voter;

/**
 * @author Amir
 *
 */
public class VoterTest {
	private Voter v;
	private Circunscripcion c= new Circunscripcion("ast", new ComunidadAutonoma("AA"));
	private ColegioElectoral ce = new ColegioElectoral("cole", "pola", c);

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		v = new Voter();
		assertEquals(31, v.hashCode());
		v = new Voter("a", "b", "c", "d");
		assertEquals(131, v.hashCode());
	
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#Voter()}.
	 */
	@Test
	public final void testVoter() {
		v = new Voter();
		assertNull(v.getColegio());
		assertNotNull(v.getElecciones());
		assertEquals(0,v.getElecciones().size());
		assertNull(v.getEmail());
		assertNull(v.getNif());
		assertNull(v.getNombre());
		assertNull(v.getPassword());
		
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#Voter(es.uniovi.asw.model.ColegioElectoral)}.
	 */
	@Test
	public final void testVoterColegioElectoral() {
		v = new Voter(ce);
		assertEquals(ce,v.getColegio());
		assertNotNull(v.getElecciones());
		assertEquals(0,v.getElecciones().size());
		assertNull(v.getEmail());
		assertNull(v.getNif());
		assertNull(v.getNombre());
		assertNull(v.getPassword());
		
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#Voter(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testVoterStringStringStringString() {
		v = new Voter("a", "b", "c", "d");
		assertEquals("a", v.getNombre());
		assertEquals("b", v.getEmail());
		assertEquals("c", v.getPassword());
		assertEquals("d", v.getNif());
		
		
	}
	
	@Test
	public final void testSets() {
		v = new Voter("a", "b", "c", "d");
		assertEquals("a", v.getNombre());
		assertEquals("b", v.getEmail());
		assertEquals("c", v.getPassword());
		assertEquals("d", v.getNif());
		
		v.setNombre("x");
		v.setEmail("y");
		v.setPassword("z");
		v.setNif("t");
		assertEquals("x", v.getNombre());
		assertEquals("y", v.getEmail());
		assertEquals("z", v.getPassword());
		assertEquals("t", v.getNif());
		
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#toString()}.
	 */
	@Test
	public final void testToString() {
		v = new Voter("a", "b", "c", "d");
		assertEquals("Voter [nombre=a, email=b, nif=d, password=c]", v.toString());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voter#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		v = new Voter("a", "b", "c", "d");
		Voter v2 = new Voter("a", "b", "c", "otroNif");
		
		assertTrue(v.equals(v));
		
		assertFalse(v.equals(new Object()));
		assertFalse(v.equals(c));
		
		assertFalse(v.equals(v2));
		assertFalse(v2.equals(v));
		
		v2.setNif(null);
		assertFalse(v.equals(v2));
		assertFalse(v2.equals(v));
		
		
		
		
	}

}

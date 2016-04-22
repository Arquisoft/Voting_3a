/**
 * 
 */
package es.uniovi.asw.cobertura.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Circunscripcion;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.ComunidadAutonoma;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voto;

/**
 * @author Drunk
 *
 */
public class VotoTest {
	
	private Voto v;
	private ComunidadAutonoma co = new ComunidadAutonoma("AA");
	private Circunscripcion c= new Circunscripcion("ast", co);
	private ColegioElectoral ce = new ColegioElectoral("cole", "pola", c);
	private Eleccion e= new Eleccion("elec");
	private Candidatura candi = new Candidatura("nom", "desc", "prog", e);

	/**
	 * Test method for {@link es.uniovi.asw.model.Voto#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		v=new Voto(ce);
		assertEquals(1922, v.hashCode());
	
		v=new Voto(candi);
		assertEquals(97627882, v.hashCode());
	}


	/**
	 * Test method for {@link es.uniovi.asw.model.Voto#Voto(es.uniovi.asw.model.ColegioElectoral)}.
	 */
	@Test
	public final void testVotoColegioElectoral() {
		v=new Voto(ce);
		assertEquals(ce,v.getColegio());
		assertNull(v.getOpcion());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voto#Voto(es.uniovi.asw.model.Candidatura)}.
	 */
	@Test
	public final void testVotoCandidatura() {
		v=new Voto(candi);
		assertEquals(candi,v.getOpcion());
		assertNull(v.getColegio());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voto#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		v=new Voto(ce);
		Voto v1,v2;
		v1=new Voto(candi);
		
		assertTrue(v.equals(v));
		
		assertFalse(v.equals(new Object()));
		assertFalse(v.equals("otrotipodato"));

		assertFalse(v.equals(v1));
		assertFalse(v1.equals(v));
		
		v2=new Voto(candi);
		v2.setColegio(ce);
		
		assertFalse(v.equals(v2));
		assertFalse(v2.equals(v));
		assertFalse(v2.equals(v1));
		assertFalse(v1.equals(v2));
		
	}

}

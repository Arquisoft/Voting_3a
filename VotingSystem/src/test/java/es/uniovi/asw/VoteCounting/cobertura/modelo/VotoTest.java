/**
 * 
 */
package es.uniovi.asw.VoteCounting.cobertura.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
	private Circunscripcion c = new Circunscripcion("ast", co);
	private ColegioElectoral ce = new ColegioElectoral("cole", "pola", c);
	private Eleccion e = new Eleccion("elec");
	private Candidatura candi = new Candidatura("nom", "desc", "prog", e);

	/**
	 * Test method for {@link es.uniovi.asw.model.Voto#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		v = new Voto(ce, candi);
		assertEquals(31, ce.hashCode());
		assertEquals(96706283, v.hashCode());
	}

	/**
	 * Test method for
	 * {@link es.uniovi.asw.model.Voto#Voto(es.uniovi.asw.model.ColegioElectoral)}
	 * .
	 */
	@Test
	public final void testVotoColegioElectoral() {
		v = new Voto(ce, candi);
		assertEquals(ce, v.getColegio());
	}

	/**
	 * Test method for
	 * {@link es.uniovi.asw.model.Voto#Voto(es.uniovi.asw.model.Candidatura)}.
	 */
	@Test
	public final void testVotoCandidatura() {
		v = new Voto(ce, candi);
		assertEquals(candi, v.getOpcion());
	}

	/**
	 * Test method for {@link es.uniovi.asw.model.Voto#equals(java.lang.Object)}
	 * .
	 */
	@Test
	public final void testEqualsObject() {
		v = new Voto(ce, candi);
		Voto v1, v2;
		v1 = new Voto(ce, candi);

		assertTrue(v.equals(v));

		assertFalse(v.equals(new Object()));
		assertFalse(v.equals("otrotipodato"));

		assertTrue(v.equals(v1));
		assertTrue(v1.equals(v));

		v2 = new Voto(ce, candi);
		v2.setColegio(ce);

		assertTrue(v.equals(v2));
		assertTrue(v2.equals(v));
		assertTrue(v2.equals(v1));
		assertTrue(v1.equals(v2));

	}

}

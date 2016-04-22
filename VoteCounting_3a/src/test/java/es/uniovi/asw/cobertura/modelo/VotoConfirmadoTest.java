/**
 * 
 */
package es.uniovi.asw.cobertura.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.model.VotoConfirmado;

/**
 * @author Amir
 *
 */
public class VotoConfirmadoTest {
	
	private Eleccion e= new Eleccion("elec");
	private Voter vr= new Voter("a", "b", "c", "d");
	private VotoConfirmado v;

	/**
	 * Test method for {@link es.uniovi.asw.model.VotoConfirmado#VotoConfirmado(es.uniovi.asw.model.Voter, es.uniovi.asw.model.Eleccion)}.
	 */
	@Test
	public final void testVotoConfirmadoVoterEleccion() {
		v = new VotoConfirmado(vr, e);
		assertEquals(e,v.getEleccion());
		assertEquals(vr,v.getVotante());
	
	}
	
	@Test
	public final void testHash() {
		v = new VotoConfirmado(vr, e);
		assertEquals(97517792,v.hashCode());
	}
	
	@Test
	public final void testEquals() {
		v = new VotoConfirmado(vr, e);
		VotoConfirmado vc = new VotoConfirmado(vr, e);
		VotoConfirmado v1 = new VotoConfirmado(vr, e);
		VotoConfirmado v2 = new VotoConfirmado(vr, e);
		
		assertTrue(v.equals(v));
		assertTrue(v.equals(vc));
		
		v1.setEleccion(null);
		v2.setVotante(null);
		assertFalse(v.equals(new Object()));
		assertFalse(v.equals(v1));
		assertFalse(v1.equals(v));
		assertFalse(v.equals(v2));
		assertFalse(v2.equals(v));
		assertFalse(v2.equals(v1));
		assertFalse(v1.equals(v2));

	}
	
	@Test
	public final void testHaVotado() {
		v = new VotoConfirmado(vr, e);
		v.setHaVotado(false);
		assertFalse(v.isHaVotado());
		v.setHaVotado(true);
		assertTrue(v.isHaVotado());
	}


	/**
	 * Test method for {@link es.uniovi.asw.model.VotoConfirmado#toString()}.
	 */
	@Test
	public final void testToString() {
		v = new VotoConfirmado(vr, e);
		String s="VotoConfirmado "
				+ "[votante=Voter [nombre=a, email=b, nif=d, password=c], "
				+ "eleccion=Eleccion [id=null, nombre=elec, fechaInicio=null, fechaFin=null, horaInicio=null, horaFin=null, "
				+ "opciones=[]], haVotado=false]";

		assertEquals(s,v.toString());
		
	}

}

/**
 * 
 */
package es.uniovi.asw.VoteCounting.cobertura.Types;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.uniovi.asw.model.types.VotoConfirmadoKey;

/**
 * @author Amir
 *
 */
public class VotoConfirmadokeyTest {
	
	private VotoConfirmadoKey vc; 

	/**
	 * Test method for {@link es.uniovi.asw.model.types.VotoConfirmadokey#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		vc = new VotoConfirmadoKey();
		assertEquals(961, vc.hashCode());
		vc.setEleccion(1L);
		vc.setVotante(2L);
		assertEquals(994, vc.hashCode());
	}
	
	@Test
	public final void testSets() {
		vc = new VotoConfirmadoKey();
	
		Long l1=1L;
		Long l2=2L;
		vc.setEleccion(l1);
		vc.setVotante(l2);
		
		assertEquals(l1, vc.getEleccion());
		assertEquals(l2, vc.getVotante());

	}

	/**
	 * Test method for {@link es.uniovi.asw.model.types.VotoConfirmadokey#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		vc = new VotoConfirmadoKey();
		vc.setEleccion(1L);
		vc.setVotante(2L);
		VotoConfirmadoKey vc1 = new VotoConfirmadoKey();
		VotoConfirmadoKey vc2 = new VotoConfirmadoKey();
		
		assertTrue(vc1.equals(vc2));
		assertTrue(vc.equals(vc));
		
		assertFalse(vc.equals(new Object()));
		assertFalse(vc.equals("esotracosa"));
		
		assertFalse(vc.equals(vc2));
		assertFalse(vc2.equals(vc));
		
		vc1.setEleccion(1L);
		assertFalse(vc1.equals(vc2));
		assertFalse(vc2.equals(vc1));
		
		vc2.setVotante(2L);
		assertFalse(vc1.equals(vc2));
		assertFalse(vc2.equals(vc1));

	}

}

/**
 * 
 */
package es.uniovi.asw.cobertura.Types;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.model.types.VotoConfirmadokey;

/**
 * @author Amir
 *
 */
public class VotoConfirmadokeyTest {
	
	private VotoConfirmadokey vc; 

	/**
	 * Test method for {@link es.uniovi.asw.model.types.VotoConfirmadokey#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		vc = new VotoConfirmadokey();
		assertEquals(961, vc.hashCode());
		vc.setEleccion(1L);
		vc.setVotante(2L);
		assertEquals(994, vc.hashCode());
	}
	
	@Test
	public final void testSets() {
		vc = new VotoConfirmadokey();
	
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
		vc = new VotoConfirmadokey();
		vc.setEleccion(1L);
		vc.setVotante(2L);
		VotoConfirmadokey vc1 = new VotoConfirmadokey();
		VotoConfirmadokey vc2 = new VotoConfirmadokey();
		
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

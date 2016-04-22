/**
 * 
 */
package es.uniovi.asw.cobertura.Types;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.model.types.UserPassInitStop;

/**
 * @author Amir
 *
 */
public class UserPassInitStopTest {
	private String usuario="user";
	private String contraseña="pass";
	private Long id=985L;


	private UserPassInitStop ups;
	/**
	 * Test method for {@link es.uniovi.asw.model.types.UserPassInitStop#UserPassInitStop(java.lang.String, java.lang.String, java.lang.Long)}.
	 */
	@Test
	public final void testUserPassInitStop() {
		ups = new UserPassInitStop(usuario, contraseña, id);
		assertEquals(contraseña,ups.getContraseña());
		assertEquals(usuario,ups.getUsuario());
		assertEquals(id,ups.getId());
	}

	@Test
	public final void testSets() {
		ups = new UserPassInitStop(usuario, contraseña, id);
		assertEquals(contraseña,ups.getContraseña());
		assertEquals(usuario,ups.getUsuario());
		assertEquals(id,ups.getId());

		Long id2=666L;
		ups.setContraseña(contraseña+1);
		ups.setUsuario(usuario+1);
		ups.setId(id2);


		assertEquals(contraseña+1,ups.getContraseña());
		assertEquals(usuario+1,ups.getUsuario());
		assertEquals(id2,ups.getId());
	}

}

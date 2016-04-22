package es.uniovi.asw.dBUpdate.validate;

import es.uniovi.asw.model.Voter;

/**
 * Clase que comprueba los campos vacíos
 * 
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public class EmptyFieldValidation implements Validate{

	@Override
	public void validation( Voter voter ) {
		if(voter.getNif().trim().length() == 0 
				|| voter.getEmail().trim().length() == 0
				|| voter.getNombre().trim().length() == 0){
			throw new IllegalStateException("Existen campos vacíos para el votante: "
					+ voter.getNombre());
		}
	}
	
	

}

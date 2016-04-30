package es.uniovi.asw.dBUpdate.validate;

import es.uniovi.asw.model.Voter;

/**
 * Clase que comprueba que el nombre y el email no se introducen como
 * numéricos
 * 
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public class StringFormatValidation implements Validate{
	
	@Override
	public void validation(Voter voter) throws IllegalStateException {
		if(voter.getNombre().matches("^-?\\d+$")){
			throw new IllegalStateException("El campo nombre debe ser textual: " + voter);
		}
		if(voter.getEmail().matches("^-?\\d+$")){
			throw new IllegalStateException("El campo email debe ser alfanumerico: " + voter);
		}
	}

}

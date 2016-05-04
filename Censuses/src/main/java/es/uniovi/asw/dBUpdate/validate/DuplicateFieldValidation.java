package es.uniovi.asw.dBUpdate.validate;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Voter;

/**
 * Clase que comprueba los campos duplicados
 * 
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public class DuplicateFieldValidation implements Validate{
	
	private List<String> nifFields = new ArrayList<String>();
	private List<String> emailFields = new ArrayList<String>();

	@Override
	public void validation( Voter voter ) {
		if( nifFields.contains( voter.getNif() ) ){
			throw new IllegalStateException("DNI " + voter.getNif() + " duplicado");
		}else{
			nifFields.add( voter.getNif() );
		}
		if( emailFields.contains( voter.getEmail() ) ){
			throw new IllegalStateException("Email " + voter.getEmail() + " duplicado");
		}else{
			emailFields.add( voter.getEmail() );
		}
	}	
}

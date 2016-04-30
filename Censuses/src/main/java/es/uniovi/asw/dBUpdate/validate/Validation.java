package es.uniovi.asw.dBUpdate.validate;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.reportWriter.WreportR;

/**
 * Clase aplica todas las validaciones necesarias sobre los
 * distintos campos de un votante
 * 
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public class Validation {
	
	private List<Validate> validations;
	
	public Validation(){
		validations =   new ArrayList<Validate>();
		validations.add( new StringFormatValidation() );
		validations.add( new EmptyFieldValidation() );
		validations.add( new DuplicateFieldValidation() );
		validations.add( new EmailFieldValidation() );
		validations.add( new NIFFieldValidation() );
	}
	
	public Voter validateAll( String fichero, Voter voter ){
		return validate( voter, fichero );
	}
	
	private Voter validate( Voter voter, String fichero ){
		try{
			for(Validate v : validations){
				v.validation( voter );
			}
		}catch(IllegalStateException ex){
			WreportR.getInstance().writeReport(fichero, ex);
			return null;
		}
		return voter;
	}

}

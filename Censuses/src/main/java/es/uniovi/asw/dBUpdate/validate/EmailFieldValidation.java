package es.uniovi.asw.dBUpdate.validate;

import es.uniovi.asw.model.Voter;

public class EmailFieldValidation implements Validate{

	@Override
	public void validation( Voter voter ) throws IllegalStateException {
		String message = "El campo email del votante: "
				+ voter.getNombre() + "  no presenta un formato correcto";
		String [] fields = voter.getEmail().split("@");
		if(fields.length < 2){
			throw new IllegalStateException( message );
		}
		if(! fields[1].contains(".")){
			throw new IllegalStateException( message );
		}
	}

}

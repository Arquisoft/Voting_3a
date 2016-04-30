package es.uniovi.asw.dBUpdate.validate;

import es.uniovi.asw.model.Voter;

/**
 * Clase que comprueba la correccion del formato del campo NIF
 * 
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public class NIFFieldValidation implements Validate{
	
	@Override
	public void validation(Voter voter) throws IllegalStateException {
		if(! validNIF(voter.getNif())){
			throw new IllegalStateException("Formato NIF inválido para el votante: " + voter);
		}
	}
	
	public boolean validNIF(String nif){
        char[] letraDni = {
            'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'
        };  
        if (nif.length() != 9){   
            return false;
        }  
        String num= "";
        int ind = 0;  
        if(nif.length() == 8) {
        	nif = "0" + nif;
        }
        if (!Character.isLetter(nif.charAt(8))) {
             return false;  
        }
        for (int i=0; i<8; i++) {
             if(!Character.isDigit(nif.charAt(i))){
                   return false;    
             }
             num += nif.charAt(i);     
        }
        ind = Integer.parseInt(num);
        ind %= 23;
        if ((Character.toUpperCase(nif.charAt(8))) != letraDni[ind]){
             return false;
       }  
       return true;
		
	}

}

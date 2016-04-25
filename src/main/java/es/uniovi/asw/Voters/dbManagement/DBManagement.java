package es.uniovi.asw.dbManagement;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.types.ChangePass;
import es.uniovi.asw.types.UserPass;

public interface DBManagement {

	public Voter save(Voter voter);

	public Voter getVoter(String email);

	public Voter getVoter(UserPass userPass);

	public Boolean changePassword(ChangePass changePass);
	
	//public VoterRepository _getVoterRepository();

}
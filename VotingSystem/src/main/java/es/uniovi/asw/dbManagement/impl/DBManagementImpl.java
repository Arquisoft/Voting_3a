package es.uniovi.asw.dbManagement.impl;

import es.uniovi.asw.Voters.types.ChangePass;
import es.uniovi.asw.Voters.types.UserPass;
import es.uniovi.asw.dbManagement.Persistence;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.model.Voter;

public class DBManagementImpl {

	public DBManagementImpl() {
	}

	public DBManagementImpl(VoterRepository voterRepository) {
		Persistence.voter = voterRepository;
	}

	public Voter save(Voter voter) {
		return Persistence.voter.save(voter);
	}

	public Voter getVoter(String email) {
		return Persistence.voter.findOneByEmail(email);
	}

	public Voter getVoter(UserPass userPass) {
		return Persistence.voter.findByEmailAndPassword(userPass.getLogin(), userPass.getPassword());
	}

	public boolean changePassword(ChangePass changePass) {
		if (changePass == null || changePass.getLogin() == null)
			return false;

		Voter voter = Persistence.voter.findOneByEmail(changePass.getLogin());

		if (voter == null || !voter.getPassword().equals(changePass.getOldPassword()))
			return false;
		voter.setPassword(changePass.getNewPassword());
		Persistence.voter.save(voter);
		return true;
	}

}

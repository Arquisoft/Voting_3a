package es.uniovi.asw.dbmanagement.impl;

import es.uniovi.asw.dbmanagement.Persistence;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.voters.types.ChangePass;
import es.uniovi.asw.voters.types.UserPass;

public class DBManagementImpl {

	public DBManagementImpl() {
		Persistence.voter = null;
	}

	public DBManagementImpl(VoterRepository voterRepository) {
		Persistence.voter = voterRepository;
	}

	public VoterRepository getVoterRepository() {
		return Persistence.voter;
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

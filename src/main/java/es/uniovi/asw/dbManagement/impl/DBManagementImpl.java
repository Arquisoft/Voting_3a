package es.uniovi.asw.dbManagement.impl;

import es.uniovi.asw.Voters.types.ChangePass;
import es.uniovi.asw.Voters.types.UserPass;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.model.Voter;

//@Component
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
public class DBManagementImpl {

	private VoterRepository voterRepository;

	public DBManagementImpl() {
	}

	public DBManagementImpl(VoterRepository voterRepository) {
		this.voterRepository = voterRepository;
	}

	public Voter save(Voter voter) {
		return voterRepository.save(voter);
	}

	public void save2(Voter voter) {
		voterRepository.save(voter);
	}

	public Voter getVoter(String email) {
		return voterRepository.findOneByEmail(email);
	}

	public Voter getVoter(UserPass userPass) {
		return voterRepository.findByEmailAndPassword(userPass.getLogin(), userPass.getPassword());
	}

	public Boolean changePassword(ChangePass changePass) {
		if (changePass == null || changePass.getLogin() == null)
			return false;

		Voter voter = voterRepository.findOneByEmail(changePass.getLogin());

		if (voter == null || !voter.getPassword().equals(changePass.getOldPassword()))
			return false;
		voter.setPassword(changePass.getNewPassword());
		voterRepository.save(voter);
		return true;
	}

}

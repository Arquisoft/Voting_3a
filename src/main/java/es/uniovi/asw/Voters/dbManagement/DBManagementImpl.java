package es.uniovi.asw.dbManagement;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.types.ChangePass;
import es.uniovi.asw.types.UserPass;

//@Component
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
public class DBManagementImpl implements DBManagement {

	private VoterRepository voterRepository;

	public DBManagementImpl() {}
	
	public DBManagementImpl(VoterRepository voterRepository) {
		this.voterRepository = voterRepository;
	}

	@Override
	public Voter save(Voter voter) {
		return voterRepository.save(voter);
	}
	
	public void save2(Voter voter) {
		voterRepository.save(voter);
	}

	@Override
	public Voter getVoter(String email) {
		return voterRepository.findByEmail(email);
	}

	@Override
	public Voter getVoter(UserPass userPass) {
		return voterRepository.findByEmailAndPassword(userPass.getLogin(), userPass.getPassword());
	}

	@Override
	public Boolean changePassword(ChangePass changePass) {
		if (changePass == null || changePass.getLogin() == null)
			return false;
		
		Voter voter = voterRepository.findByEmail(changePass.getLogin());
		
		if (voter == null || !voter.getPassword().equals(changePass.getOldPassword()))
			return false;
		voter.setPassword(changePass.getNewPassword());
		voterRepository.save(voter);
		return true;
	}

	//@Override
	public VoterRepository _getVoterRepository() {
		return voterRepository;
	}
}

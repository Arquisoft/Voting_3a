package es.uniovi.asw.dbManagement;

import java.util.HashMap;
import java.util.Map;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.types.ChangePass;
import es.uniovi.asw.types.UserPass;

//@Component
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
public class DBManagementVirtualImpl implements DBManagement {

	private static Map<String, Voter> voterRepository;

	public DBManagementVirtualImpl() {
		if (voterRepository == null) {
			voterRepository = new HashMap<String, Voter>();
			voterRepository.put("user1@mail.com", new Voter("User1", "user1@mail.com", "user1", "12312321Q", 123));
			voterRepository.put("user2@mail.com", new Voter("User2", "user2@mail.com", "user2", "12323421D", 553));
			voterRepository.put("user3@mail.com", new Voter("User3", "user3@mail.com", "user3", "23442321J", 124));
			voterRepository.put("user4@mail.com", new Voter("User4", "user4@mail.com", "user4", "62323421L", 751));
			voterRepository.put("user5@mail.com", new Voter("User5", "user5@mail.com", "user5", "12349853H", 129));
		}
	}

	@Override
	public Voter save(Voter voter) {
		voterRepository.put(voter.getEmail(), voter);
		return voter;
	}

	@Override
	public Voter getVoter(String email) {
		return voterRepository.get(email);
	}

	@Override
	public Voter getVoter(UserPass userPass) {
		Voter voter = voterRepository.get(userPass.getLogin());
		return voter != null && voter.getPassword().equals(userPass.getPassword()) ? voter : null;
	}

	@Override
	public Boolean changePassword(ChangePass changePass) {

		if (changePass.getOldPassword() == null || changePass.getOldPassword().equals(changePass.getNewPassword()))
			return false;

		Voter voter = voterRepository.get(changePass.getLogin());

		if (voter == null || !voter.getPassword().equals(changePass.getOldPassword()))
			return false;

		voter.setPassword(changePass.getNewPassword());
		return true;
	}
}

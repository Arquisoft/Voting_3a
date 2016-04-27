package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl;

import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.GetVoters;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.model.Voter;

class GetVotersImpl implements GetVoters{
	
	public Voter findByEmail(String email, VoterRepository vtRep){
		List<Voter> votantes = (List<Voter>) vtRep.findAll();
		for(Voter v : votantes){
			if(v.getEmail().equals(email))
				return v;
		}
		return null;
	}
	
	public List<Voter> findAll(VoterRepository vtRep){
		return (List<Voter>) vtRep.findAll();
	}

}

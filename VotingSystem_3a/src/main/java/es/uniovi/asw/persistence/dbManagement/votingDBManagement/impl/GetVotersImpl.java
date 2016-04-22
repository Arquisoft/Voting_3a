package es.uniovi.asw.persistence.dbManagement.votingDBManagement.impl;

import java.util.List;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.persistence.dbManagement.repository.VoterRepository;
import es.uniovi.asw.persistence.dbManagement.votingDBManagement.GetVoters;

class GetVotersImpl implements GetVoters{
	
	public Voter findByEmail(String email, VoterRepository vtRep){
		List<Voter> votantes = vtRep.findAll();
		for(Voter v : votantes){
			if(v.getEmail().equals(email))
				return v;
		}
		return null;
	}
	
	public List<Voter> findAll(VoterRepository vtRep){
		return vtRep.findAll();
	}

}

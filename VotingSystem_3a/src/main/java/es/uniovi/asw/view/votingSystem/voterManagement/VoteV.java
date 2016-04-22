package es.uniovi.asw.view.votingSystem.voterManagement;

import es.uniovi.asw.business.votingSystem.votingManagement.impl.ServicesFactory;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoterRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public class VoteV {

	VoterRepository vtRep;
	VotingRepository vRep;
	VoteRepository voRep;
	ConfirmedVoteRepository cvRep;

	public VoteV(VotingRepository vRep, VoterRepository vtRep, VoteRepository voRep, ConfirmedVoteRepository cvRep) {
		this.vtRep = vtRep;
		this.vRep = vRep;
		this.voRep = voRep;
		this.cvRep = cvRep;
	}

	public void meterVoto(Candidatura cand, Voter votante) {
		ServicesFactory.newVote().votar(vRep, vtRep, voRep, cvRep, votante, cand);
	}

}

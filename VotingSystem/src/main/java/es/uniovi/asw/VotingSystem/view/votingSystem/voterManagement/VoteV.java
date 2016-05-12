package es.uniovi.asw.votingSystem.view.votingSystem.voterManagement;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbmanagement.VoteRepository;
import es.uniovi.asw.dbmanagement.VoterRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.impl.ServicesFactory;

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

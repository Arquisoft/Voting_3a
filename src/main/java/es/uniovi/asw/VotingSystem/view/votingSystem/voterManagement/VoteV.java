package es.uniovi.asw.VotingSystem.view.votingSystem.voterManagement;

import es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement.impl.ServicesFactory;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbManagement.VoteRepository;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Voter;

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

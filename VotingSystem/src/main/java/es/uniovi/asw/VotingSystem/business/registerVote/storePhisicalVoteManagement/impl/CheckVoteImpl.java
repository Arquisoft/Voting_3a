package es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.impl;

import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.CheckVote;
import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl.PersistenceFactory;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;

public class CheckVoteImpl implements CheckVote{

    public boolean alreadyVoted(ConfirmedVoteRepository cvRep, Long idVotante, Long idEleccion) {

        return PersistenceFactory.newHasVoted().alreadyVoted(cvRep,idVotante,idEleccion);

    }

}

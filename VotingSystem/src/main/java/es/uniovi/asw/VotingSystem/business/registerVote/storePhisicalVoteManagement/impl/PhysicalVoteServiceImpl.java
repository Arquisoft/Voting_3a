package es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.impl;

import java.util.List;

import es.uniovi.asw.VotingSystem.business.registerVote.storePhisicalVoteManagement.PhysicalVoteService;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.dbManagement.VoterRepository;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;


public class PhysicalVoteServiceImpl implements PhysicalVoteService{
    private static PhysicalVoteServiceImpl ourInstance = new PhysicalVoteServiceImpl();

    public static PhysicalVoteServiceImpl getInstance() {
        return ourInstance;
    }

    private PhysicalVoteServiceImpl() {
    }

    @Override
    public boolean add(String dniVoter, long idElection,
                                  ConfirmedVoteRepository cvRep,
                                  VoterRepository voterRep,
                                  VotingRepository vRep) {
        return new AddPhysicalVoteImpl().add(dniVoter, idElection, cvRep, voterRep, vRep);
    }

    @Override
    public boolean checkVote(long idVotante, long idEleccion, ConfirmedVoteRepository cvRep) {
        return new CheckVoteImpl().alreadyVoted(cvRep,idVotante,idEleccion);
    }

    @Override
    public List<Voter> getVoters(VoterRepository voterRep) {
        return new GetVotersImpl().getVoters(voterRep);
    }

    @Override
    public Iterable<Eleccion> getActiveVoter(VotingRepository vRep) {
        return new GetActiveVotingsImpl().getActiveVoter(vRep);
    }
}

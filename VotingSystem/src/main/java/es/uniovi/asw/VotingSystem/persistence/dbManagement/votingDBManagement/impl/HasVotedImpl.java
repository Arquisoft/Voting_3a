package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl;

import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.HasVoted;
import es.uniovi.asw.dbManagement.ConfirmedVoteRepository;
import es.uniovi.asw.model.VotoConfirmado;

class HasVotedImpl implements HasVoted {

	@Override
	public boolean alreadyVoted(ConfirmedVoteRepository cvRep, Long idVotante, Long idEleccion) {
		List<VotoConfirmado> confirmados = (List<VotoConfirmado>) cvRep.findAll();
		if (confirmados != null) {
			for (VotoConfirmado vc : confirmados) {
				if (vc.getEleccion().getId().equals(idEleccion) && vc.getVotante().getId().equals(idVotante)) {
					return true;
				}
			}
		}
		return false;
	}

}

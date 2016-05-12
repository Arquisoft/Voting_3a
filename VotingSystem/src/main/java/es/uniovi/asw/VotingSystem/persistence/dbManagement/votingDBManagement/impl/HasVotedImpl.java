package es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.impl;

import java.util.List;

import es.uniovi.asw.dbmanagement.ConfirmedVoteRepository;
import es.uniovi.asw.model.VotoConfirmado;
import es.uniovi.asw.votingSystem.persistence.dbManagement.votingDBManagement.HasVoted;

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

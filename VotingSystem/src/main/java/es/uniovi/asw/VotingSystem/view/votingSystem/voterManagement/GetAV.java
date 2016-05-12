package es.uniovi.asw.votingSystem.view.votingSystem.voterManagement;

import java.util.List;

import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.votingSystem.business.votingSystem.votingManagement.impl.ServicesFactory;

public class GetAV {

	VotingRepository vRep;
	List<Eleccion> activas;

	public GetAV(VotingRepository vRep) {
		this.vRep = vRep;
	}

	public List<Eleccion> getEleccionesActivas() {
		activas = ServicesFactory.newGetActiveVotings().eleccionesActivas(vRep);
		return activas;
	}

}

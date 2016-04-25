package es.uniovi.asw.view.votingSystem.voterManagement;

import java.util.List;

import es.uniovi.asw.business.votingSystem.votingManagement.impl.ServicesFactory;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;

public class GetAV {

	
	VotingRepository vRep;
	List<Eleccion> activas;
	
	public GetAV(VotingRepository vRep){
		this.vRep = vRep;
	}
	
	public List<Eleccion> getEleccionesActivas(){
		activas = ServicesFactory.newGetActiveVotings().eleccionesActivas(vRep);
		return activas;
	}
	
}

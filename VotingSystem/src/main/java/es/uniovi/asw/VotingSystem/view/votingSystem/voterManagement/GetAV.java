package es.uniovi.asw.VotingSystem.view.votingSystem.voterManagement;

import java.util.List;

import es.uniovi.asw.VotingSystem.business.votingSystem.votingManagement.impl.ServicesFactory;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;

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

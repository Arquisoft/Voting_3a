package es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.VotingSystem.persistence.dbManagement.votingDBManagement.GetActiveVotings;
import es.uniovi.asw.dbManagement.VotingRepository;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;
import es.uniovi.asw.persistence.dbManagement.votingDBManagement.GetActiveVotings;

class GetActiveVotingsImpl implements GetActiveVotings {

	@Override
	public List<Eleccion> getActiveVotings(VotingRepository vr) {
		List<Eleccion> resultado = new ArrayList<Eleccion>();
		for (Eleccion e : vr.findAll()) {
			if (e.isActiva()) {
				resultado.add(e);
			}
		}
		return resultado;
	}

	public List<Eleccion> eleccionesActivas(VotingRepository vRep) {
		List<Eleccion> elecciones = vRep.findByActivaTrue();
		List<Eleccion> aux = new ArrayList<Eleccion>();
		Date inicio, fin = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(Eleccion e : elecciones){
			try {
				inicio = sdf.parse(e.getFechaInicio().toString());
				fin = sdf.parse(e.getFechaFin().toString());
				if(inicio.getTime() < new Date(System.currentTimeMillis()).getTime() 
						&& fin.getTime() > new Date(System.currentTimeMillis()).getTime()){
					aux.add(e);
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		return aux;
	}

	public Eleccion buscarPorId(VotingRepository vRep, Long idEleccion) {
		return vRep.findOne(idEleccion);
	}

}

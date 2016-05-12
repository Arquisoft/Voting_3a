package es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.impl;

import java.util.List;

import es.uniovi.asw.dbmanagement.CandidacyRepository;
import es.uniovi.asw.dbmanagement.VotingRepository;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.AddCandidacyC;
import es.uniovi.asw.votingSystem.persistence.dbManagement.adminDBManagement.GetCandidacyS;

class AddCandidacyCImpl implements AddCandidacyC {

	@Override
	public void saveCandidacys(VotingRepository vRep, CandidacyRepository cRep, List<Candidatura> candidaturas,
			Long id) {
		GetCandidacyS gc = new GetCandidacySImpl();
		List<Candidatura> cand = gc.getCandidacys(vRep, cRep, id);
		for (int i = 0; i < cand.size() - 1; i++) {
			if (cand.get(i).getNombre().contains("Voto en blanco")) {
				cand.get(i).setDescripcion("Sin descripción");
				cand.get(i).setProgramaElectoral("No existe programa electoral disponible");
				cRep.save(cand);
			}
			cand.get(i).setDescripcion(candidaturas.get(i).getDescripcion());
			cand.get(i).setProgramaElectoral(candidaturas.get(i).getProgramaElectoral());
			cRep.save(cand);
		}
	}

}

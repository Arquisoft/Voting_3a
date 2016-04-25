package es.uniovi.asw.business.systemConfiguration.votingParamsManagement;

import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.candidacyManagement.CandidacyService;
import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.candidacyManagement.CandidacyServiceImpl;
import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.pollingStationManagement.PollingStationService;
import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.pollingStationManagement.PollingStationServiceImpl;
import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.voting.VotingTypeService;
import es.uniovi.asw.business.systemConfiguration.votingParamsManagement.voting.VotingTypeServiceImpl;

public class SysConfigServiceFactory {
	
	public static VotingTypeService getVotingService(){
		return new VotingTypeServiceImpl();
	}
	
	public static CandidacyService getCandidacyService(){
		return new CandidacyServiceImpl();
	}
	
	public static PollingStationService getPollingStationService(){
		return new PollingStationServiceImpl();
	}

}

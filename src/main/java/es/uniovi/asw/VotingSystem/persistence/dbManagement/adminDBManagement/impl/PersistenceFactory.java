package es.uniovi.asw.persistence.dbManagement.adminDBManagement.impl;

import es.uniovi.asw.persistence.dbManagement.adminDBManagement.AddCandidacyC;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.AddPollingStation;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.AddVotingType;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.GetCandidacyS;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.GetPollingStationsP;
import es.uniovi.asw.persistence.dbManagement.adminDBManagement.GetVotings;

public class PersistenceFactory{
	
	public static AddCandidacyC addCandidacys(){
		return new AddCandidacyCImpl();
	}
	
	public static AddPollingStation addPollingStation(){
		return new AddPollingStationImpl();
	}
	
	public static AddVotingType addVotingType(){
		return new AddVotingTypeImpl();
	}
	
	public static GetCandidacyS getCandidacys(){
		return new GetCandidacySImpl();
	}
	
	public static GetPollingStationsP getPollingStations(){
		return new GetPollingStationsPImpl();
	}
	
	public static GetVotings getVotings(){
		return new GetVotingsImpl();
	}

}

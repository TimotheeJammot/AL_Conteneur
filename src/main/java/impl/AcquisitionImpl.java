package impl;

import java.util.Set;

import services.Acquisition;
import services.AcquisitionFailure;
import services.OCComponent;
import services.OCService;

public class AcquisitionImpl implements Acquisition {

	ConteneurComposants conteneur;
	
	public AcquisitionImpl(ConteneurComposants conteneur) {
		this.conteneur = conteneur;
	}
	
	@Override
	public Set<OCComponent> getNewComponents() throws AcquisitionFailure {

		return conteneur.getNouveauxComposants();
	}

	@Override
	public Set<OCComponent> getDisappearedComponents() throws AcquisitionFailure {
		
		return conteneur.getDisappearedComposants();
	}

	@Override
	public Set<OCComponent> getCurrentComponents() throws AcquisitionFailure {
		
		return conteneur.getActuelsComposants();
	}

	@Override
	public Set<OCService> getNewServices() throws AcquisitionFailure {
		
		return conteneur.getNouveauxServices();
	}

	@Override
	public Set<OCService> getDisappearedServices() throws AcquisitionFailure {
		
		return conteneur.getDisappearedServices();
	}

	@Override
	public Set<OCService> getCurrentServices() throws AcquisitionFailure {
		
		return conteneur.getActuelsServices();
	}

}
